package com.basic.java.generic.test.ex1;

public class Pair<T,U> {
    private T firstValue;
    private U secondValue;

    public void setFirst(T first) {
        this.firstValue = first;
    }

    public T getFirst() {
        return firstValue;
    }

    public void setSecond(U second) {
        this.secondValue = second;

    }

    public U getSecond() {
        return secondValue;
    }

    @Override
    public String toString() {
        return "Pair{ firstValue : " +
                    firstValue + " secondValue : " + secondValue +
                "}";
    }
}
