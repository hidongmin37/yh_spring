
package com.java_basic.construct;

public class MemberConstruct {

    public String name;
    public int age;

    public int grade;

    MemberConstruct(String name, int age, int grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        System.out.println("이름: " + this.name + " 나이: " + this.age + " 성적: " + this.grade);
    }
}
