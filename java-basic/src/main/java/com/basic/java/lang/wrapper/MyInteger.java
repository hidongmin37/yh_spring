package com.basic.java.lang.wrapper;

public class MyInteger {
    private final int value;

    public int getValue() {
        return value;
    }

    public MyInteger(int value) {
        this.value = value;
    }
    public int compareTO(int target) {
        if (value < target) {
            return -1;
        } else if (value > target) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
