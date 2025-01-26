package com.basic.java.collection.array;

public class MyArrayListV3Main {

    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3();

        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);


        // 원하는 위치에 추가
        System.out.println("addLast");
        list.add(3, "addList"); // O(1)
        System.out.println(list);

        System.out.println("addFirst");
        list.add(0, "addFirst"); // O(1)
        System.out.println(list);


        // 삭제
        Object remove = list.remove(4);
        System.out.println("remove(4) = " + remove);
        System.out.println("list = " + list);


        Object remove2 = list.remove(0);
        System.out.println("remove(0) = " + remove2);
        System.out.println("list = " + list);

    }
}
