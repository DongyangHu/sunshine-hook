package com.hudongyang.sunshinehook.common.enums;

import lombok.Getter;

/**
 * @author dongyang.hu
 * @date 2019/12/7 17:18
 */
@Getter
public enum ResultEnum {

    /**
     * success
     */
    SUCCESS(200, "success"),

    /**
     * failed
     */
    FAILED(-1, "failed"),

    /**
     * check auth failed
     */
    AUTH_ERROR(1001, "auth failed"),

    /**
     * not support event
     */
    NOT_SUPPORT_EVENT(1002, "not support event"),

    /**
     * branch filter
     */
    BRANCH_FILTER(1003, "branch_filter"),

    /**
     * the config is not init
     */
    CONFIG_NOT_FOUND(1004, "deploy config not found"),

    /**
     * request body error
     */
    ILLEGAL_PARAM(1005, "illegal param"),

    /**
     * source error
     */
    REQUEST_SOURCE_ERROR(1006, "request source error"),
    ;
    private final int code;
    private final String message;

    ResultEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return this.getCode() == SUCCESS.getCode();
    }
}
