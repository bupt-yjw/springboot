package com.spring.boot.demo;

import com.spring.boot.demo.controller.HelloController;
import com.spring.boot.demo.service.HelloService;
import io.swagger.annotations.ApiOperation;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
*
*Created by weiyongjun on 2018/8/10
*/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MailSendTest {
    private MockMvc mvc;
    @Autowired
    private JavaMailSender mailSender;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @ApiOperation(value = "测试邮件发送，需要在邮箱设置权限，需要短信验证，故没测试")
    @Test
    public void testMailSend() throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("3321911932qq.com");
        message.setTo("bjweiyongjun@corp.netease.com");
        message.setSubject("test");
        message.setText("test,test");
    }
}
