package com.hudongyang.sunshinehook.web.config.inteceptor;

import com.alibaba.fastjson.JSON;
import com.hudongyang.sunshinehook.common.bean.HookEvent;
import com.hudongyang.sunshinehook.common.bean.Result;
import com.hudongyang.sunshinehook.common.bean.giteepayloads.GiteePushEvent;
import com.hudongyang.sunshinehook.common.bean.githubpayloads.GitHubPushEvent;
import com.hudongyang.sunshinehook.common.constants.BaseConstants;
import com.hudongyang.sunshinehook.common.enums.*;
import com.hudongyang.sunshinehook.common.utils.HmacShaUtils;
import com.hudongyang.sunshinehook.common.utils.WebUtils;
import com.hudongyang.sunshinehook.storage.monitor.RunningData;
import com.hudongyang.sunshinehook.web.config.SunshineHookConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * A Interceptor for Git's hook
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 15:33
 */
@Slf4j
@Configuration
public class HookEventInterceptor implements HandlerInterceptor {

    @Autowired
    private SunshineHookConfig config;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RunningData.increase(RunningData.MonitorType.REQUEST_COUNT);
        String requestString = this.getRequestString(request);
        if (StringUtils.isEmpty(requestString)) {
            WebUtils.sendResponse(response, Result.result(ResultEnum.ILLEGAL_PARAM));
            RunningData.increase(RunningData.MonitorType.FILTER_COUNT);
            return false;
        }

        // check source
        EventSourceEnum source = this.getSource(request);
        if (source == EventSourceEnum.UN_KNOW) {
            WebUtils.sendResponse(response, Result.result(ResultEnum.REQUEST_SOURCE_ERROR));
            RunningData.increase(RunningData.MonitorType.FILTER_COUNT);
            return false;
        }

        // check secret code
        ResultEnum checkAuth = this.checkAuth(request, requestString);
        if (!checkAuth.isSuccess()) {
            WebUtils.sendResponse(response, Result.result(ResultEnum.AUTH_ERROR));
            RunningData.increase(RunningData.MonitorType.FILTER_COUNT);
            return false;
        }

        // check event type
        EventTypeEnum<? extends EventTypeEnum<?>> eventType = this.getEventType(request, source);
        if (Objects.isNull(eventType)) {
            WebUtils.sendResponse(response, Result.result(ResultEnum.NOT_SUPPORT_EVENT));
            RunningData.increase(RunningData.MonitorType.FILTER_COUNT);
            return false;
        }
        if (config.getEventFilter().stream().noneMatch(e -> eventType.getType().equals(e))) {
            WebUtils.sendResponse(response, Result.result(ResultEnum.NOT_SUPPORT_EVENT));
            RunningData.increase(RunningData.MonitorType.FILTER_COUNT);
            return false;
        }

        // params
        this.transferEvent(request, source, eventType, requestString);
        return true;
    }

    private void transferEvent(HttpServletRequest request, EventSourceEnum source,
                               EventTypeEnum<? extends EventTypeEnum<?>> eventType, String requestString) {
        HookEvent hookEvent = HookEvent.builder()
                .source(source)
                .eventType(eventType)
                .createTime(System.currentTimeMillis())
                .build();
        // GitHub
        if (source == EventSourceEnum.GIT_HUB) {
            if (eventType == GitHubEventTypeEnum.PUSH_EVENT) {
                GitHubPushEvent event = JSON.parseObject(requestString, GitHubPushEvent.class);
                String eventRef = event.getRef();
                String branch = eventRef.replaceFirst(BaseConstants.GIT_HUB_BRANCH_REFS_PREFIX, "");
                hookEvent.setBranch(branch);
                hookEvent.setEvent(event);
            }
        }

        // Gitee
        if (source == EventSourceEnum.GIT_EE) {
            if (eventType == GiteeEventTypeEnum.PUSH_EVENT) {
                GiteePushEvent event = JSON.parseObject(requestString, GiteePushEvent.class);
                String eventRef = event.getRef();
                String branch = eventRef.replaceFirst(BaseConstants.GIT_EE_BRANCH_REFS_PREFIX, "");
                hookEvent.setBranch(branch);
                hookEvent.setEvent(event);
            }
        }
        request.setAttribute(BaseConstants.REQUEST_EVENT_PARAM, hookEvent);
    }

    /**
     * 鉴权
     *
     * @param request
     * @param requestString
     * @return
     */
    private ResultEnum checkAuth(HttpServletRequest request, String requestString) throws UnsupportedEncodingException {
        EventSourceEnum source = this.getSource(request);
        if (source == EventSourceEnum.GIT_HUB) {
            return this.check4GitHub(request, requestString) ? ResultEnum.SUCCESS : ResultEnum.AUTH_ERROR;
        }
        if (source == EventSourceEnum.GIT_EE) {
            return this.check4Gitee(request) ? ResultEnum.SUCCESS : ResultEnum.AUTH_ERROR;
        }
        return ResultEnum.AUTH_ERROR;
    }

    /**
     * GitHub鉴权
     *
     * @param request
     * @param requestString
     * @return
     */
    private boolean check4GitHub(HttpServletRequest request, String requestString) {
        String sign = request.getHeader(GitHubHeaderEnum.SIGNATURE.getHeader());
        String sign256 = request.getHeader(GitHubHeaderEnum.SIGNATURE_256.getHeader());
        String sha1String = BaseConstants.SHA1_PREFIX + HmacShaUtils.sha1String(requestString, config.getSecretKey());
        String sha256String = BaseConstants.SHA256_PREFIX + HmacShaUtils.sha256String(requestString, config.getSecretKey());
        if (log.isDebugEnabled()) {
            log.debug("check sign, requestSign:{}, sha1String:{}", sign, sha1String);
            log.debug("check sign, requestSign:{}, sha256String:{}", sign256, sha256String);
        }
        return sha1String.equals(sign) && sha256String.equals(sign256);
    }

    /**
     * Gitee鉴权
     *
     * @param request
     * @return
     */
    private boolean check4Gitee(HttpServletRequest request) throws UnsupportedEncodingException {
        String sign = request.getHeader(GiteeHeaderEnum.SIGNATURE.getHeader());
        // 密码校验
        if (sign.equals(config.getSecretKey())) {
            return true;
        }
        // 秘钥校验
        String timestamp = request.getHeader(GiteeHeaderEnum.TIMESTAMP.getHeader());
        String signString = timestamp + "\n" + config.getSecretKey();
        String sha256String = HmacShaUtils.sha256Base64AndUrlEncode(signString, config.getSecretKey());
        return sha256String.equals(sign);
    }

    /**
     * 事件来源
     *
     * @param request
     * @return
     */
    private EventSourceEnum getSource(HttpServletRequest request) {
        // GitHub
        String userAgent = request.getHeader(HttpHeaderEnum.USER_AGENT.getHeader());
        if (Objects.nonNull(userAgent) && userAgent.toLowerCase().contains(EventSourceEnum.GIT_HUB.getSource())) {
            return EventSourceEnum.GIT_HUB;
        }

        if (Objects.nonNull(userAgent) && userAgent.equals(EventSourceEnum.GIT_EE.getHeader())) {
            return EventSourceEnum.GIT_EE;
        }
        return EventSourceEnum.UN_KNOW;
    }

    /**
     * 事件类型
     *
     * @param request
     * @return
     */
    private EventTypeEnum<? extends EventTypeEnum<?>> getEventType(HttpServletRequest request, EventSourceEnum source) {
        // GitHub
        if (source == EventSourceEnum.GIT_HUB) {
            String eventType = request.getHeader(GitHubHeaderEnum.EVENT_TYPE.getHeader());
            return GitHubEventTypeEnum.getByType(eventType);
        }

        // Gitee
        if (source == EventSourceEnum.GIT_EE) {
            String eventType = request.getHeader(GiteeHeaderEnum.EVENT_TYPE.getHeader());
            return GiteeEventTypeEnum.getByType(eventType);
        }
        return null;
    }

    /***
     * convert request params to string
     *
     * @param request
     * @return
     */
    private String getRequestString(HttpServletRequest request) {
        try {
            BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(), Charset.defaultCharset()));
            StringBuilder sb = new StringBuilder();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                sb.append(inputStr);
            }
            return sb.toString();
        } catch (Exception e) {
            log.error("HookEventInterceptor getRequestString exception. request:{}", request, e);
            return null;
        }
    }
}
