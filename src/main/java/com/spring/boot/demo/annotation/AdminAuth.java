package com.spring.boot.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by caigen on 2018/2/2.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AdminAuth {

}
