package com.hudongyang.sunshinehook.common.enums;

import lombok.Getter;

/**
 * 事件类型
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/13 19:11
 */
@Getter
public enum EventSourceEnum {

    /**
     * 未知
     */
    UN_KNOW(-1, "un_know", "un_know"),

    /**
     * GitHub
     */
    GIT_HUB(1, "github", "GitHub-Hookshot/*"),

    /**
     * Gitee
     */
    GIT_EE(2, "gitee", "git-oschina-hook"),
    ;

    private final int code;
    private final String source;
    private final String header;

    EventSourceEnum(int code, String source, String header) {
        this.code = code;
        this.source = source;
        this.header = header;
    }
}
