package com.spring.boot.demo;

import com.spring.boot.demo.config.EnvironmentConfig;
import com.spring.boot.demo.controller.HelloController;
import com.spring.boot.demo.service.HelloService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
*
*Created by weiyongjun on 2018/8/10
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestControllerTest.class)
@ComponentScan({"com.spring.boot.demo.service"})
public class TestControllerTest {

    @Autowired
    private HelloService helloService;
    @Test
    public void testUserController() throws Exception {

        for(int i = 0; i<10; i++) {
            System.out.println(1111);
            helloService.getInum(i);
            helloService.getHello();
        }
    }
}
