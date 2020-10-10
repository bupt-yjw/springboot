package com.spring.boot.demo.config.resolver;

import com.spring.boot.demo.annotation.AdminAuth;
import com.spring.boot.demo.config.interceptor.ThreadLocalInterceptor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by caigen on 2018/1/30.
 */
@Slf4j
@Component
public class AdminInfoResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        log.info("AdminInfoResolver supportsParameter 调用");
        if (parameter.hasParameterAnnotation(AdminAuth.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        log.info("AdminInfoResolver resolveArgument 调用");
        if (parameter.hasParameterAnnotation(AdminAuth.class)) {
            return ThreadLocalInterceptor.getAdminInfoLocal();
        }
        return null;
    }
}
