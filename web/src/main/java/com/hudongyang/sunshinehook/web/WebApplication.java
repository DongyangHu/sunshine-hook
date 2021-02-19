package com.hudongyang.sunshinehook.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author Dongyang.Hu
 * @version 1.0.0
 * @date 2021/2/9 22:34
 */
@Slf4j
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(WebApplication.class, args);
        } catch (Exception e) {
            log.info("Sunshine-Hook started");
        }
    }

}
