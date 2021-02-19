package com.hudongyang.sunshinehook.web.controller;

import com.hudongyang.sunshinehook.common.bean.HookEvent;
import com.hudongyang.sunshinehook.common.bean.Result;
import com.hudongyang.sunshinehook.common.constants.BaseConstants;
import com.hudongyang.sunshinehook.common.enums.EventSourceEnum;
import com.hudongyang.sunshinehook.engine.dispatcher.EventDispatcher;
import com.hudongyang.sunshinehook.web.config.SunshineHookConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/13 17:08
 */
@Slf4j
@RestController
@RequestMapping(BaseConstants.REQUEST_PREFIX)
public class GitHookEventController {

    @Autowired
    private SunshineHookConfig config;
    @Autowired
    private EventDispatcher<HookEvent> eventDispatcher;

    @PostMapping(BaseConstants.HOOK_EVENT_URL)
    public Result event(HttpServletRequest request) {
        HookEvent event = (HookEvent) request.getAttribute(BaseConstants.REQUEST_EVENT_PARAM);
        // 分支
        if (config.getBranchFilter().stream().noneMatch(e -> event.getBranch().equals(e))) {
            eventDispatcher.dispatch(event);
        } else {
            log.info("branch filter skip, branch:{}, config:{}", event.getBranch(), config.getBranchFilter());
        }
        return Result.success();
    }
}
