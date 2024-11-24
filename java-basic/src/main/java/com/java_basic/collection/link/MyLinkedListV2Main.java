package com.java_basic.collection.link;



public class MyLinkedListV2Main {
    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();
        System.out.println("=====데이터 추가====");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);

        // 첫번째 항목에 추가,삭제
        System.out.println("첫번째 항목에 추가");
        list.add(0, "d");
        System.out.println("list = " + list);

        System.out.println("첫번째 항목에 삭제");
        list.remove(0);
        System.out.println("list = " + list);

        // 중간 항목에 추가,삭제
        System.out.println("중간 항목 추가");
        list.add(1,"e");
        System.out.println("list = " + list);

        System.out.println("중간 항목 삭제");
        list.remove(1);
        System.out.println("list = " + list);
    }
}
