package com.hudongyang.sunshinehook.common.enums;

/**
 * 事件类型枚举
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 18:49
 */
public interface EventTypeEnum<E extends EventTypeEnum<E>> {
    /**
     * 事件类型字符串
     *
     * @return
     */
    String getType();
}
