package com.basic.annotaion.basic.inherited.validator;

public class User {
    @NotEmpty(message = "이름은 비어있을 수 없습니다.")
    private String name;

    @Range(min =  1, max = 100,message = "나이는 1에서 100 사이여야 합니다.")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

}
