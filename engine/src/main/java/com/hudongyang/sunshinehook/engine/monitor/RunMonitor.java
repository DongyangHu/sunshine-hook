package com.hudongyang.sunshinehook.engine.monitor;

import com.hudongyang.sunshinehook.common.utils.ThreadPoolUtils;
import com.hudongyang.sunshinehook.common.utils.TimeUtils;
import com.hudongyang.sunshinehook.storage.monitor.RunningData;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/18 19:15
 */
@Slf4j
public class RunMonitor {

    private static final int POOL_SIZE = 1;
    private static final String THREAD_NAME = "run-monitor";
    private static final ScheduledThreadPoolExecutor EXECUTOR_POOL = ThreadPoolUtils.newScheduledPool(POOL_SIZE, THREAD_NAME);

    public void start() {
        EXECUTOR_POOL.scheduleWithFixedDelay(this::monitor, 1, 66, TimeUnit.SECONDS);
    }

    private void monitor() {
        log.info("Running Monitor: {}", buildLog());
    }

    private String buildLog() {
        String template = "| %-14s | %-14s | %-14s | %-14s | %-14s | %-14s |";
        String title = String.format(template, "run-time", "request-total", "request-filter", "event-total", "event-success", "event-failed");
        String split = "\n|-----------------------------------------------------------------------------------------------------|\n";
        String baseTitle = "|                                Running    Monitor(" + TimeUtils.now() + ")                              |";
        String content = String.format(template,
                RunningData.getRunningTime(),
                RunningData.get(RunningData.MonitorType.REQUEST_COUNT),
                RunningData.get(RunningData.MonitorType.FILTER_COUNT),
                RunningData.get(RunningData.MonitorType.RECEIVE_EVENT_COUNT),
                RunningData.get(RunningData.MonitorType.SUCCESS_EVENT_COUNT),
                RunningData.get(RunningData.MonitorType.FAILED_EVENT_COUNT)
        );
        return "\n" + split + baseTitle + split + title + split + content + split + "\n";
    }

}
