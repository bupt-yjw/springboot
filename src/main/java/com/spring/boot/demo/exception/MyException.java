package com.spring.boot.demo.exception;

import lombok.Data;

/**
 * Created by weiyongjun on 2018/8/11
 */
@Data
public class MyException extends Exception {

    private String url;
    private Integer errorCode;

    public MyException(String message, Integer errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
