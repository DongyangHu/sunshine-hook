package com.hudongyang.sunshinehook.common.utils;

import com.alibaba.fastjson.JSON;
import com.hudongyang.sunshinehook.common.constants.BaseConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;


/**
 * some common method for web
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/15 15:36
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WebUtils {

    /**
     * send response
     *
     * @param response
     * @param result
     */
    public static <T> void sendResponse(HttpServletResponse response, T result) throws IOException {
        response.setCharacterEncoding(BaseConstants.DEFAULT_CHARSET);
        response.setContentType(BaseConstants.JSON_TYPE);
        byte[] resultBytes = JSON.toJSONString(result).getBytes(Charset.defaultCharset());
        response.getOutputStream().write(resultBytes);
    }
}
