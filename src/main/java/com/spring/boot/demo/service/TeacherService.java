package com.spring.boot.demo.service;

import org.springframework.stereotype.Service;

/**
 * Created by weiyongjun on 2020/1/8
 */
@Service(value = "teacherService")
public class TeacherService implements PersonService {

    @Override
    public String hello(String name) {
        return "teacher";
    }
}
