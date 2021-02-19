package com.hudongyang.sunshinehook.common.enums;

import lombok.Getter;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 16:11
 */
@Getter
public enum HttpHeaderEnum {

    /**
     * content-type
     */
    CONTENT_TYPE("content-type"),

    /**
     * User-Agent
     */
    USER_AGENT("User-Agent"),
    ;

    private final String header;

    HttpHeaderEnum(String header) {
        this.header = header;
    }
}
