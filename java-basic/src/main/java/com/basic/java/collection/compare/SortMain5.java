package com.basic.java.collection.compare;

import java.util.TreeSet;

public class SortMain5 {

    public static void main(String[] args) {

        MyUser aUser = new MyUser("a", 30);
        MyUser bUser = new MyUser("b", 20);
        MyUser cUser = new MyUser("c", 10);

        TreeSet<MyUser> treeSet1 = new TreeSet<>();
        treeSet1.add(aUser);
        treeSet1.add(bUser);
        treeSet1.add(cUser);
        System.out.println("Comparable 기본 정렬");
        System.out.println(treeSet1); // treeSet은 들어가는 순간 값에 대해서 정렬이 되어있음

        // 기본 정렬이 아닌 IdComparator에 의해서 정렬
        TreeSet<MyUser> treeSet2 = new TreeSet<>(new IdComparator());
        treeSet2.add(aUser);
        treeSet2.add(bUser);
        treeSet2.add(cUser);
        System.out.println("IdComparator 정렬");
        System.out.println(treeSet2);

    }
}
