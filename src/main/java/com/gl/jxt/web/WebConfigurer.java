package com.gl.jxt.web;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gl.jxt.web.interceptor.InitInterceptor;
import com.gl.jxt.web.listener.InitListener;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {
//
//    @Bean
//    public ServletListenerRegistrationBean listenerRegist() {
//        ServletListenerRegistrationBean srb = new ServletListenerRegistrationBean();
//        srb.setListener(new InitListener());
//        return srb;
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //这里可以添加多个拦截器
        registry.addInterceptor(new InitInterceptor()).addPathPatterns("/**");
    }
}
