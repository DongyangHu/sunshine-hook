package com.hudongyang.sunshinehook.web.boot;

import com.hudongyang.sunshinehook.engine.handler.EventHandler;
import com.hudongyang.sunshinehook.engine.monitor.RunMonitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/19 22:43
 */
@Slf4j
@Component
public class Launcher implements ApplicationRunner {

    private final EventHandler eventHandler;
    private final RunMonitor runMonitor;

    public Launcher(EventHandler eventHandler, RunMonitor runMonitor) {
        this.eventHandler = eventHandler;
        this.runMonitor = runMonitor;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        eventHandler.start();
        runMonitor.start();
    }
}
