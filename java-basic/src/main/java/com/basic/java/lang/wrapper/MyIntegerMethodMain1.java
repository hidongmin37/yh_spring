package com.basic.java.lang.wrapper;
public class MyIntegerMethodMain1 {
    public static void main(String[] args) {
        MyInteger myInteger = new MyInteger(10);
        int i = myInteger.compareTO(5);
        int i2 = myInteger.compareTO(10);
        int i3 = myInteger.compareTO(20);
        System.out.println("i = " + i);
        System.out.println("i2 = " + i2);
        System.out.println("i3 = " + i3);
    }


}
