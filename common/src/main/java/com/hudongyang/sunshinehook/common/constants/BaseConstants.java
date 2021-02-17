package com.hudongyang.sunshinehook.common.constants;

/**
 * 常量池
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/13 17:26
 */
public class BaseConstants {

    /**
     * root url
     */
    public static final String REQUEST_PREFIX = "sunshine-hook";

    /**
     * Hook接口
     */
    public static final String HOOK_EVENT_URL = "event";

    /**
     * 默认编码
     */
    public static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 数据格式
     */
    public static final String JSON_TYPE = "application/json";

    /**
     * sha1签名校验前缀
     */
    public static final String SHA1_PREFIX = "sha1=";

    /**
     * sha256签名校验前缀
     */
    public static final String SHA256_PREFIX = "sha256=";

    /**
     * GitHub分支获取前缀
     */
    public static final String GIT_HUB_BRANCH_REFS_PREFIX = "refs/heads/";

    /**
     * 请求参数
     */
    public static final String REQUEST_EVENT_PARAM = "event";

    /**
     * shell命令前置
     */
    public static final String SHELL_EXEC_PREFIX = "/bin/sh";

    /**
     * shell命令前置
     */
    public static final String SHELL_EXEC_OPTIONS = "-c";

}
