package com.hudongyang.sunshinehook.web.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.Collections;
import java.util.List;

/**
 * 业务配置
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/9 22:34
 */
@Data
@Slf4j
@Configuration
@ConfigurationProperties(prefix = "sunshine-hook.config")
public class SunshineHookConfig implements ApplicationListener<ContextRefreshedEvent> {

    /**
     * 缓存队列大小
     */
    private int maxSize = 100;

    /**
     * 消费频率,单位:s
     */
    private long consumeDelay = 10L;

    /**
     * Hook事件分支筛选
     */
    private List<String> branchFilter = Collections.emptyList();

    /**
     * Hook事件类型筛选
     */
    private List<String> eventFilter = Collections.emptyList();

    /**
     * 收到事件后执行脚本路径
     */
    private String scriptPath = StringUtils.EMPTY;

    /**
     * Hook请求加密秘钥
     */
    private String secretKey = StringUtils.EMPTY;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Sunshine-Hook config, branchFilter:{}, eventFilter:{}, scriptPath:{}, secretKey:{}, consumeDelay:{}",
                branchFilter, eventFilter, scriptPath, secretKey, consumeDelay);
    }
}
