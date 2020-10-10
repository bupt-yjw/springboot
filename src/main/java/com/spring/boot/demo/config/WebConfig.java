package com.spring.boot.demo.config;

import com.spring.boot.demo.config.interceptor.LoginInterceptor;
import com.spring.boot.demo.config.interceptor.ThreadLocalInterceptor;
import com.spring.boot.demo.config.resolver.AdminInfoResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Created by bjweiyongjun
 * spring boot 加载的时候，会先加载interceptor，然后加载 resolver
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {


    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AdminInfoResolver adminInfoResolver;

    @Override
    protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(adminInfoResolver);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getThreadLocalInterceptor());
        registry.addInterceptor(loginInterceptor);
    }

    @Bean
    public HandlerInterceptor getThreadLocalInterceptor() {
        return new ThreadLocalInterceptor();
    }

}
