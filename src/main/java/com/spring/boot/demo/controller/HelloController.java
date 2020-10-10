package com.spring.boot.demo.controller;

import com.spring.boot.demo.annotation.AdminAuth;
import com.spring.boot.demo.config.ExecutorConfig;
import com.spring.boot.demo.entity.AdminInfo;
import com.spring.boot.demo.entity.SearchParams;
import com.spring.boot.demo.exception.MyException;
import com.spring.boot.demo.service.HelloService;
import com.spring.boot.demo.service.PersonService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private PersonService studentService;
    @Autowired
    private PersonService teacherService;

    @ApiOperation(value = "hello world", notes = "")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String test(@AdminAuth AdminInfo adminInfo) throws Exception {
        return "hello world";
    }

    @RequestMapping(value = "/hellotest", method = RequestMethod.GET)
    public String hello(String name) {
        name = "12";
        return studentService.hello(name) + "=======>" + teacherService.hello(name);
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public String exception() throws Exception {
        throw new MyException("1", 0);
    }

    @RequestMapping(value = "/testAsync", method = RequestMethod.GET)
    public String testAsync() throws Exception {
        for(int i = 0; i<10; i++){
            helloService.getInum(i);
            helloService.getHello();
        }
        return "";
    }

    @ApiOperation(value = "selectUser")
    @ApiImplicitParam(name = "params", value = "selectuser", required = true, dataType = "SearchParams")
    @RequestMapping(value = "/selectUser", method = RequestMethod.GET)
    public String selectUser(@RequestBody SearchParams params) throws Exception {
        return "";
    }

    public static void main(String[] a) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ExecutorConfig.class);
        HelloService h = context.getBean(HelloService.class);
        for(int i = 0; i<10; i++){
            h.getInum(i);
            h.getHello();
        }
        context.close();
    }

}
