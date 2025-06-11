package com.basic.annotaion.basic.inherited.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Range {

    // 최소값
    int min();
    // 최대값
    int max();
    String message() default "범위를 넘었습니다.";

}
