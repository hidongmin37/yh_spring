package com.java_basic.designpatterns.creational_patterns.builder;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class SpringExample {
    public static void main(String[] args) {
        UriComponents builder = UriComponentsBuilder
                .newInstance()
                .scheme("http").host("localhost").port(8080)
                .queryParam("name", "whiteship")
                .queryParam("age", 18).build()
                .encode();
        System.out.println(builder.toUriString());
    }
}
