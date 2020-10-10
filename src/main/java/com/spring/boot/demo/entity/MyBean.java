package com.spring.boot.demo.entity;

import javax.annotation.PostConstruct;

/**
 * Created by weiyongjun on 2019/6/17
 */
public class MyBean {

    public MyBean(){
        System.out.println("generate MyBean Instance");
    }

    @PostConstruct
    public void init(){
        System.out.println("MyBean Resources Initialized");
    }
}
