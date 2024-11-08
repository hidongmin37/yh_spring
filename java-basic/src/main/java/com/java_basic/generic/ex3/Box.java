package com.java_basic.generic.ex3;

public class Box<T> {

    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

}
