package com.hudongyang.sunshinehook.common.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * GitHub事件类型
 *
 * @author dongyang.hu
 * @date 2021/2/22 16:02
 */
public enum GitHubEventTypeEnum implements EventTypeEnum<GitHubEventTypeEnum> {

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

    GitHubEventTypeEnum(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return this.type;
    }

    private static final Map<String, GitHubEventTypeEnum> VALUE_MAP = Arrays.stream(GitHubEventTypeEnum.values())
            .collect(Collectors.toMap(EventTypeEnum::getType, Function.identity()));

    public static GitHubEventTypeEnum getByType(String type) {
        if (Objects.isNull(type)) {
            return null;
        }
        return VALUE_MAP.get(type);
    }
}
