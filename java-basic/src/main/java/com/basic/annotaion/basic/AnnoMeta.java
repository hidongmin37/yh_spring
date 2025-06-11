package com.basic.annotaion.basic;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

// 직접만든 타입들은 선언할 수없음.
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.METHOD,})
@Documented
public @interface AnnoMeta {

}
