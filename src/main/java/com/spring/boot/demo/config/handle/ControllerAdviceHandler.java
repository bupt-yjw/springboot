package com.spring.boot.demo.config.handle;

import com.spring.boot.demo.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by weiyongjun on 2018/8/10
 */
@ControllerAdvice
public class ControllerAdviceHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandle(HttpServletRequest request, Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.addObject("url", request.getRequestURL());
        modelAndView.setViewName(DEFAULT_ERROR_VIEW);
        return modelAndView;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public MyException defaultErrorHandle(HttpServletRequest request, MyException e) {
        e.setUrl(request.getRequestURI());
        return e;
    }
}
