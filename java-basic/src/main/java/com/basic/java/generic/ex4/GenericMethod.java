package com.basic.java.generic.ex4;

public class GenericMethod {

    public static Object objMethod(Object object) {
        System.out.println("object print = " + object);
        return object;
    }

    public static <T> T genericMethod(T object) {
        System.out.println("generic print = " + object);
        return object;
    }

    public static <T extends Number> T numberMethod(T object) {
        System.out.println("bound print = " + object);
        return object;
    }  // 제한도 가능


}
