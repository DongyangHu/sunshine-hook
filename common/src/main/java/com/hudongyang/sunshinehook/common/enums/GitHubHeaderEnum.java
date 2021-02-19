package com.hudongyang.sunshinehook.common.enums;

import lombok.Getter;

/**
 * @author dongyang.hu
 * @date 2019/12/7 18:23
 */
@Getter
public enum GitHubHeaderEnum {

    /**
     * 序列
     */
    DELIVERY("X-GitHub-Delivery"),

    /**
     * 事件类型
     */
    EVENT_TYPE("X-GitHub-Event"),

    /**
     * sha1签名
     */
    SIGNATURE("X-Hub-Signature"),

    /**
     * sha256签名
     */
    SIGNATURE_256("X-Hub-Signature-256"),
    ;

    private final String header;

    GitHubHeaderEnum(String header) {
        this.header = header;
    }
}
