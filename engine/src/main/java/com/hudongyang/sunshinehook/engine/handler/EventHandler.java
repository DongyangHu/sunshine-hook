package com.hudongyang.sunshinehook.engine.handler;

import com.hudongyang.sunshinehook.common.bean.HookEvent;
import com.hudongyang.sunshinehook.storage.queue.HookEventQueue;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/17 1:28
 */
@Slf4j
public class EventHandler extends EventHandlerWrapper<HookEvent> {

    private static final long DEFAULT_CONSUME_DELAY = 10L;

    public EventHandler(HookEventQueue<HookEvent> queue, long consumeDelay) {
        super(queue, consumeDelay);
    }

    public EventHandler(HookEventQueue<HookEvent> queue) {
        super(queue, DEFAULT_CONSUME_DELAY);
    }

    @Override
    void handle(HookEvent event) {
        log.info("received event:{}", event);
    }
}
