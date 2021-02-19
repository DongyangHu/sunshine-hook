package com.hudongyang.sunshinehook.web.boot;

import com.hudongyang.sunshinehook.common.bean.HookEvent;
import com.hudongyang.sunshinehook.engine.dispatcher.EventDispatcher;
import com.hudongyang.sunshinehook.engine.handler.EventHandler;
import com.hudongyang.sunshinehook.engine.monitor.RunMonitor;
import com.hudongyang.sunshinehook.storage.queue.HookEventQueue;
import com.hudongyang.sunshinehook.web.config.SunshineHookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 启动管理
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/9 22:23
 */
@Component
public class BootManager {

    @Autowired
    private SunshineHookConfig config;

    @Bean
    @Primary
    public HookEventQueue<HookEvent> initQueue() {
        return new HookEventQueue<>(config.getMaxSize());
    }

    @Bean
    @Primary
    public EventDispatcher<HookEvent> initDispatcher(HookEventQueue<HookEvent> queue) {
        return new EventDispatcher<>(queue);
    }

    @Bean
    @Primary
    public EventHandler initHandler(HookEventQueue<HookEvent> queue) {
        return new EventHandler(queue, config.getConsumeDelay(), config.getScriptPath());
    }

    @Bean
    @Primary
    public RunMonitor initMonitor() {
        return new RunMonitor();
    }
}
