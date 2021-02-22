package com.hudongyang.sunshinehook.common.enums;

import lombok.Getter;

/**
 * @author dongyang.hu
 * @date 2021/2/22 15:09
 */
@Getter
public enum GiteeHeaderEnum {

    /**
     * 签名
     */
    SIGNATURE("X-Gitee-Token"),

    /**
     * 触发 WebHook 的时间戳
     */
    TIMESTAMP("X-Gitee-Timestamp"),

    /**
     * 标识触发的钩子类型
     */
    EVENT_TYPE("X-Gitee-Event"),
    ;

    private final String header;

    GiteeHeaderEnum(String header) {
        this.header = header;
    }
}
