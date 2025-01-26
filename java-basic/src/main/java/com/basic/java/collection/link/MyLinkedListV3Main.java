package com.basic.java.collection.link;



public class MyLinkedListV3Main {
    public static void main(String[] args) {
        MyLinkedListV3<String> list = new MyLinkedListV3<>();
        System.out.println("=====데이터 추가====");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");

        System.out.println(list);


        MyLinkedListV3<Integer> integerList = new MyLinkedListV3<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        Integer i = integerList.get(0);
        System.out.println("i = " + i);

    }
}
