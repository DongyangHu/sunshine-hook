package com.hudongyang.sunshinehook.common.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 * 事件类型枚举
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 18:49
 */
@Getter
public enum EventTypeEnum {

    /**
     * 未知
     */
    UN_KNOW("un_know"),

    /**
     * push event
     */
    PUSH_EVENT("push"),
    ;

    private final String type;

    EventTypeEnum(String type) {
        this.type = type;
    }

    public static EventTypeEnum getByName(String type) {
        if (Objects.nonNull(type)) {
            return Arrays.stream(EventTypeEnum.values()).filter(e -> e.getType().equalsIgnoreCase(type)).findFirst().orElse(UN_KNOW);
        }
        return UN_KNOW;
    }
}
