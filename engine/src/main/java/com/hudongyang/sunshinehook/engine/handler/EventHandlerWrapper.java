package com.hudongyang.sunshinehook.engine.handler;

import com.hudongyang.sunshinehook.common.bean.HookEvent;
import com.hudongyang.sunshinehook.common.utils.ThreadPoolUtils;
import com.hudongyang.sunshinehook.storage.queue.HookEventQueue;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Objects;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 21:55
 */
@Slf4j
public abstract class EventHandlerWrapper<T> {

    private final HookEventQueue<T> queue;
    private final long consumeDelay;

    private static final int DRAIN_TO_MAX_SIZE = 100;
    private static final int POOL_SIZE = 1;
    private static final String THREAD_NAME = "event-handler";
    private static final ScheduledThreadPoolExecutor EXECUTOR_POOL = ThreadPoolUtils.newScheduledPool(POOL_SIZE, THREAD_NAME);

    public EventHandlerWrapper(HookEventQueue<T> queue, long consumeDelay) {
        this.queue = queue;
        this.consumeDelay = consumeDelay;
        this.listen();
    }

    private void listen() {
        EXECUTOR_POOL.scheduleWithFixedDelay(this::consume, consumeDelay, consumeDelay, TimeUnit.SECONDS);
        log.info("event handler init success. consumeDelay:{}s", consumeDelay);
    }

    private void consume() {
        try {
            T item = queue.poll();
            if (Objects.isNull(item)) {
                log.info("event handler queue is empty");
                return;
            }
            LinkedList<T> eventList = new LinkedList<>();
            queue.drainTo(eventList, DRAIN_TO_MAX_SIZE);
            eventList.addFirst(item);
            eventList.forEach(this::handle);
            log.info("handle event, consume size:{}", eventList.size());
        } catch (Exception e) {
            log.error("handle event, exception", e);
        }
    }

    /**
     * consume event
     *
     * @param event current event
     */
    abstract void handle(T event);
}
