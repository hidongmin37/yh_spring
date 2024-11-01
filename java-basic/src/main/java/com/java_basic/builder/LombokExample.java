package com.java_basic.builder;

import lombok.Builder;

@Builder
public class LombokExample {

    private String title;

    private int nights;

    private int days;

    public static void main(String[] args) {
        LombokExample lombokExample = LombokExample.builder()
                .title("여행")
                .nights(1)
                .days(2)
                .build();
        System.out.println(lombokExample);
    }

}
