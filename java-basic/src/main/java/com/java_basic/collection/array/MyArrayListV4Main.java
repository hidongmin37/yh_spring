package com.java_basic.collection.array;

public class MyArrayListV4Main {

    public static void main(String[] args) {
        MyArrayListV4<String> list = new MyArrayListV4<>();

        list.add("a");
        list.add("b");
        list.add("c");
//        list.add(1);
        String string = list.get(0);
        System.out.println("string = " + string);

        MyArrayListV4<Integer> intList = new MyArrayListV4<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
//        intList.add("123");
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);




    }
}
