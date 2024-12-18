package com.java_basic.collection.compare;

import java.util.Collections;
import java.util.LinkedList;

public class SortMain4 {

    public static void main(String[] args) {

        MyUser aUser = new MyUser("a", 30);
        MyUser bUser = new MyUser("b", 20);
        MyUser cUser = new MyUser("c", 10);

        LinkedList<MyUser> list = new LinkedList<>();
        list.add(aUser);
        list.add(bUser);
        list.add(cUser);

        System.out.println("기본 데이터");
        System.out.println(list);

        System.out.println("Comparable 기본 정렬");
//        list.sort(null);

        Collections.sort(list);
        System.out.println(list);


        System.out.println("IdComparator 정렬");
//        list.sort(new IdComparator());
        Collections.sort(list,new IdComparator());
        System.out.println(list);
    }
}
