package com.basic.java.generic.ex1;

public class BoxMain02 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.set(10); // auto-boxing
        Integer integer = (Integer) integerBox.get(); // Object type -> Integer type (casting)
        System.out.println(integer);

        ObjectBox stringBox = new ObjectBox();
        stringBox.set("Hello");
        String string = (String) stringBox.get(); // Object type -> String type (casting)
        System.out.println(string);


        integerBox.set("Hello");
        integer = (Integer) integerBox.get(); // ClassCastException
        System.out.println(integer);
    }
}
