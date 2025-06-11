package com.basic.was.httpServer.servlet.annotaion;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Mapping {

    String value();
}
