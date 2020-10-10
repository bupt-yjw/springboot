package com.spring.boot.demo.service;

import java.util.Date;
import java.util.Random;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Created by weiyongjun on 2018/8/10
 */
@Service
public class HelloService {

    @Async("secondExecutor")
    public String getHello() {
        System.out.println(Thread.currentThread().getName());
        return "---";
    }

    @Async("firstExecutor")
    public String getInum(int i) {
        System.out.println(Thread.currentThread().getName());
        return "---";
    }

    //初始延迟1秒，每隔2秒
    @Scheduled(fixedRateString = "20000000",initialDelay = 1000)
    public void testFixedRate(){
        System.out.println("fixedRateString,当前时间：" +new Date());
    }
}
