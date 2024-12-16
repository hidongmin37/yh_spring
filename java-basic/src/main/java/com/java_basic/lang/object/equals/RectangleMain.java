package com.java_basic.lang.object.equals;

public class RectangleMain {
    public static void main(String[] args) {

        main.lang.object.equals.Rectangle rect1 = new main.lang.object.equals.Rectangle(100, 20);

        main.lang.object.equals.Rectangle rect2 = new main.lang.object.equals.Rectangle(100, 20);

        System.out.println(rect1);

        System.out.println(rect2);

        System.out.println(rect1 == rect2);

        System.out.println(rect1.equals(rect2));
    }

}
