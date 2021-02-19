package com.hudongyang.sunshinehook.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/17 18:28
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScriptUtils {

    /**
     * 执行shell脚本
     *
     * @param commands
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public static boolean executeShell(String[] commands) throws IOException, InterruptedException {
        log.info("executeShell:{}", Arrays.asList(commands));
        Process process = Runtime.getRuntime().exec(commands);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        int exitValue = process.waitFor();
        while ((line = reader.readLine()) != null) {
            log.info("execute shell result:{}", line);
        }
        return exitValue == 0;
    }
}
