package com.hudongyang.sunshinehook.engine.dispatcher;

import com.hudongyang.sunshinehook.storage.queue.HookEventQueue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;

/**
 * 事件分发
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/10 20:11
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventDispatcher<T> {

    private HookEventQueue<T> queue;

    public EventDispatcher(HookEventQueue<T> queue) {
        this.queue = queue;
    }

    public void dispatch(T e) {
        if (Objects.isNull(e)) {
            log.warn("EventDispatcher event is null");
        }
        this.queue.offer(e);
    }
}
