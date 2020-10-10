package com.spring.boot.demo.config.interceptor;

import com.spring.boot.demo.entity.AdminInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by caigen on 2018/1/30.
 */
@Component
@Slf4j
public class ThreadLocalInterceptor extends HandlerInterceptorAdapter {
    private static final ThreadLocal<AdminInfo> adminInfoLocal = new ThreadLocal<>();

    public static void setAdminInfoLocal(AdminInfo adminInfo) {
        adminInfoLocal.set(adminInfo);
    }

    public static AdminInfo getAdminInfoLocal(){
        return adminInfoLocal.get();
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("threadLocalInterceptor preHandle 调用");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
            throws Exception {
        log.info("threadLocalInterceptor postHandle 调用");
        setAdminInfoLocal(null);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("threadLocalInterceptor afterCompletion 调用");
        super.afterCompletion(request, response, handler, ex);
        setAdminInfoLocal(null);
    }

}
