package com.hudongyang.sunshinehook.common.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Gitee事件类型
 *
 * @author dongyang.hu
 * @date 2021/2/22 16:48
 */
public enum GiteeEventTypeEnum implements EventTypeEnum<GiteeEventTypeEnum> {

    /**
     * 未知
     */
    UN_KNOW("un_know"),

    /**
     * push event
     */
    PUSH_EVENT("Push Hook"),
    ;

    private final String type;

    GiteeEventTypeEnum(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    private static final Map<String, GiteeEventTypeEnum> VALUE_MAP = Arrays.stream(GiteeEventTypeEnum.values())
            .collect(Collectors.toMap(GiteeEventTypeEnum::getType, Function.identity()));

    public static GiteeEventTypeEnum getByType(String type) {
        if (Objects.isNull(type)) {
            return null;
        }
        return VALUE_MAP.get(type);
    }
}
