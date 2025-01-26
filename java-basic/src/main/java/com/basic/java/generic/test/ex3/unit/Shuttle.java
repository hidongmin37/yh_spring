package com.basic.java.generic.test.ex3.unit;

public class Shuttle<T extends BioUnit> {

    private T one;

    public void in(T unit) {
        this.one = unit;
    }


    public void showInfo() {
        System.out.println("이름: " + one.getName() + " , HP: " + one.getHp());
    }
}
