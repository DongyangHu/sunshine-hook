package com.hudongyang.sunshinehook.web.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 业务配置
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/9 22:34
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sunshine-hook.config")
public class SunshineHookConfig {

    /**
     * 事件队列配置
     */
    private EventQueueConfig eventQueueConfig;

    /**
     * Hook事件配置
     */
    private HookEventConfig hookEventConfig;

    @Data
    public static class EventQueueConfig {
        /**
         * 缓存队列大小
         */
        private int maxSize;

        /**
         * 消费频率,单位:s
         */
        private long consumeDelay;
    }

    @Data
    public static class HookEventConfig {
        /**
         * Hook事件分支筛选
         */
        private List<String> branchFilter;

        /**
         * Hook事件类型筛选
         */
        private List<String> eventFilter;

        /**
         * 收到事件后执行脚本路径
         */
        private String scriptPath;

        /**
         * Hook请求加密秘钥
         */
        private String secretKey;
    }
}
