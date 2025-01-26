package com.basic.java.collection.set;

public class MyHashSetV3Main {

    public static void main(String[] args) {
        //중복 등록
        MyHashSetV3<String> set = new MyHashSetV3<>(10);
        set.add("A");
        set.add("B");
        set.add("C");

        System.out.println(set);

        // 검색
        String searchValue = "A";
        System.out.println("set.contains(searchValue) = " + set.contains(searchValue));


    }
}
