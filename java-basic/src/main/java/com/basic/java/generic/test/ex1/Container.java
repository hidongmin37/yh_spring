package com.basic.java.generic.test.ex1;

public class Container<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public boolean isEmpty() {
        if (item == null || item == "") {
            return true;
        }
        return false;
    }

    public T getItem() {
        return item;
    }

}
