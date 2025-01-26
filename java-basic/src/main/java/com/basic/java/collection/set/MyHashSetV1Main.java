package com.basic.java.collection.set;

public class MyHashSetV1Main {
    public static void main(String[] args) {
        MyHashSetV1 myHashSetV1 = new MyHashSetV1();
        myHashSetV1.add(1);
        myHashSetV1.add(2);
        myHashSetV1.add(5);
        myHashSetV1.add(8);
        myHashSetV1.add(14);
        myHashSetV1.add(99);
        myHashSetV1.add(9);

        System.out.println("myHashSetV1 = " + myHashSetV1);

        // 검색
        int searchValue = 9;
        boolean result = myHashSetV1.contains(searchValue);
        System.out.println("myHashSetV1.contains(" + searchValue + ") = " + result);

        // 삭제
        boolean removeResult = myHashSetV1.remove(searchValue);
        System.out.println("myHashSetV1.remove(" + searchValue + ") = " + removeResult);

        System.out.println("myHashSetV1 = " + myHashSetV1);
    }
}
