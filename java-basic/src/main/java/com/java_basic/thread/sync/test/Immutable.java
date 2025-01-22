package com.java_basic.thread.sync.test;

public class Immutable {

    private final int value;
    public Immutable(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
