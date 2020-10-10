package com.spring.boot.demo.config;

import com.spring.boot.demo.entity.MyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by weiyongjun on 2019/6/17
 */
@Configuration
public class MyConfiguration {

    @Bean
    public MyBean myBean(){
        System.out.println("myBean Initialized");
        return new MyBean();
    }
}
