package com.hudongyang.sunshinehook.storage.queue;

import java.util.Collection;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Queue for event from Hook
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/9 18:52
 */
public class HookEventQueue<T> {

    private static final int DEFAULT_MAX_SIZE = 100;

    private final LinkedBlockingQueue<T> queue;

    public HookEventQueue() {
        this.queue = new LinkedBlockingQueue<>(DEFAULT_MAX_SIZE);
    }

    public HookEventQueue(int capacity) {
        this.queue = new LinkedBlockingQueue<>(capacity);
    }

    /**
     * 尝试放入一个元素,直到放入为止
     *
     * @param t        元素
     * @param time     重试间隔
     * @param timeUnit 时间单位
     */
    public void offer(T t, long time, TimeUnit timeUnit) {
        while (!this.offer(t)) {
            LockSupport.parkNanos(timeUnit.toNanos(time));
        }
    }

    /**
     * 放入一个元素
     *
     * @param t 元素
     * @return true or false
     */
    public boolean offer(T t) {
        return this.queue.offer(t);
    }

    /**
     * poll元素,无等待时间
     *
     * @return item or null
     */
    public T poll() {
        return this.queue.poll();
    }

    /**
     * drainTo
     *
     * @param collection 集合
     * @param size       取出大小
     * @return
     */
    public int drainTo(Collection<? super T> collection, int size) {
        return this.queue.drainTo(collection, size);
    }
}
