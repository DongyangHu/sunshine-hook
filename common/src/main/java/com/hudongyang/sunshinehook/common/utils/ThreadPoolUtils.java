package com.hudongyang.sunshinehook.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.Objects;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 22:29
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ThreadPoolUtils {

    private static final long KEEP_ALIVE_TIME = 60L;
    private static final int WORK_QUEUE_SIZE = 1 << 10;

    public static ThreadPoolExecutor newPool(int core, int max, String name) {
        Objects.requireNonNull(name);
        return new ThreadPoolExecutor(core, max, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(WORK_QUEUE_SIZE),
                new BasicThreadFactory.Builder()
                        .namingPattern(name + "-%d")
                        .uncaughtExceptionHandler((t, e) -> log.error("Uncaught Exception got, thread:{}", t.getName(), e))
                        .daemon(false)
                        .build(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public static ScheduledThreadPoolExecutor newScheduledPool(int corePoolSize, String name) {
        Objects.requireNonNull(name);
        return new ScheduledThreadPoolExecutor(corePoolSize,
                new BasicThreadFactory.Builder()
                        .namingPattern(name + "-%d")
                        .uncaughtExceptionHandler((t, e) -> log.error("Uncaught Exception got, thread:{}", t.getName(), e))
                        .daemon(true)
                        .build());
    }
}
