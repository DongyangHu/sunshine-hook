package com.hudongyang.sunshinehook.web.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hudongyang.sunshinehook.common.constants.BaseConstants;
import com.hudongyang.sunshinehook.web.config.inteceptor.HookEventInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dongyang.hu
 * @date 2021/2/5 18:27
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private HookEventInterceptor hookEventInterceptor;

    @Bean
    public FastJsonHttpMessageConverter converter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteNullBooleanAsFalse);
        return converter;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String filterPath = "/" + BaseConstants.REQUEST_PREFIX + "/" + BaseConstants.HOOK_EVENT_URL;
        registry.addInterceptor(hookEventInterceptor).addPathPatterns(filterPath);
    }
}
