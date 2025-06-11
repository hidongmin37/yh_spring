package com.basic.annotaion.basic;

import com.basic.network.MyLogger;

import java.lang.annotation.Retention;

// 직접만든 타입들은 선언할 수없음.
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface AnnoElement {
    String value();
    int count() default 0;
    String[] tags() default { };

    //MyLogger data() 다른 타입은 적용 x
    Class<? extends MyLogger> annoData() default MyLogger.class;
}
