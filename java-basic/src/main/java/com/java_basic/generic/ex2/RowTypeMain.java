package com.java_basic.generic.ex2;

public class RowTypeMain {
    public static void main(String[] args) {
        GenericBox<Object> objectGenericBox = new GenericBox<>();
        objectGenericBox.set(10);
        Integer result = (Integer) objectGenericBox.get();
        System.out.println("result = " + result);

    }
}
