package com.basic.java.generic.ex4;

import com.basic.java.generic.ex3.Animal;

public class AnimalMethod {

    public static <T extends Animal> void checkup(T t) {
        System.out.println("동물 이름: " + t.getName());
        System.out.println("동물 크기: " + t.getSize());
        t.sound();
    }

    public static <T extends Animal> T bigger(T t1,T t2) {
        return t1.getSize() > t1.getSize() ? t1 : t2;
    }
}
