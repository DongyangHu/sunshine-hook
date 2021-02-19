package com.hudongyang.sunshinehook.storage.monitor;

import com.hudongyang.sunshinehook.common.utils.TimeUtils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/18 19:17
 */
public class RunningData {

    /**
     * 启动时间
     */
    private static final long START_TIME = System.currentTimeMillis();

    /**
     * 请求数量
     */
    private static final AtomicInteger REQUEST_COUNT = new AtomicInteger();

    /**
     * 过滤数量
     */
    private static final AtomicInteger FILTER_COUNT = new AtomicInteger();

    /**
     * 收到的事件数量
     */
    private static final AtomicInteger RECEIVE_EVENT_COUNT = new AtomicInteger();

    /**
     * 处理成功事件数量
     */
    private static final AtomicInteger SUCCESS_EVENT_COUNT = new AtomicInteger();

    /**
     * 处理失败事件数量
     */
    private static final AtomicInteger FAILED_EVENT_COUNT = new AtomicInteger();

    /**
     * 统计类型枚举
     */
    public enum MonitorType {
        /**
         * 请求数量
         */
        REQUEST_COUNT,

        /**
         * 过滤数量
         */
        FILTER_COUNT,

        /**
         * 收到的事件数量
         */
        RECEIVE_EVENT_COUNT,

        /**
         * 处理成功事件数量
         */
        SUCCESS_EVENT_COUNT,

        /**
         * 处理失败事件数量
         */
        FAILED_EVENT_COUNT,
        ;
    }

    /**
     * 获取运行时间
     *
     * @return *天*小时*秒
     */
    public static String getRunningTime() {
        return TimeUtils.formatTime(System.currentTimeMillis() - START_TIME);
    }


    /**
     * 计数+1
     *
     * @param monitorType 监控数据类型
     */
    public static void increase(MonitorType monitorType) {
        if (monitorType == MonitorType.REQUEST_COUNT) {
            REQUEST_COUNT.incrementAndGet();
        }
        if (monitorType == MonitorType.FILTER_COUNT) {
            FILTER_COUNT.incrementAndGet();
        }
        if (monitorType == MonitorType.RECEIVE_EVENT_COUNT) {
            RECEIVE_EVENT_COUNT.incrementAndGet();
        }
        if (monitorType == MonitorType.SUCCESS_EVENT_COUNT) {
            SUCCESS_EVENT_COUNT.incrementAndGet();
        }
        if (monitorType == MonitorType.FAILED_EVENT_COUNT) {
            FAILED_EVENT_COUNT.incrementAndGet();
        }
        throw new UnsupportedOperationException(monitorType.name());
    }

    /**
     * 获取计数
     *
     * @param monitorType 监控数据类型
     * @return 计数当前值
     */
    public static int get(MonitorType monitorType) {
        if (monitorType == MonitorType.REQUEST_COUNT) {
            return REQUEST_COUNT.get();
        }
        if (monitorType == MonitorType.FILTER_COUNT) {
            return FILTER_COUNT.get();
        }
        if (monitorType == MonitorType.RECEIVE_EVENT_COUNT) {
            return RECEIVE_EVENT_COUNT.get();
        }
        if (monitorType == MonitorType.SUCCESS_EVENT_COUNT) {
            return SUCCESS_EVENT_COUNT.get();
        }
        if (monitorType == MonitorType.FAILED_EVENT_COUNT) {
            return FAILED_EVENT_COUNT.get();
        }
        throw new UnsupportedOperationException(monitorType.name());
    }
}
