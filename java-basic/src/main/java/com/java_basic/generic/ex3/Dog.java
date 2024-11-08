package com.java_basic.generic.ex3;

public class Dog extends Animal{

    public Dog(String name,int size) {
        super(name,size);
    }

    @Override
    public void sound() {
        System.out.println("멍멍");

    }
}
