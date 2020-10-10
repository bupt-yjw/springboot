package com.spring.boot.demo.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by caigen on
 */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
    int ALL_TYPE_ALLOW = -1;
    int DEVELOPER = 0;
    int VERIFY = 1;
    int REVIEW = 2;
    int CONFIRM = 3;
    @AliasFor("value")
    int[] type() default {-1};

    @AliasFor("type")
    int[] value() default {-1};


}
