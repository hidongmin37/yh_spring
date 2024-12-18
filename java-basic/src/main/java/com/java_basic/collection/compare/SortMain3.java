package com.java_basic.collection.compare;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortMain3 {

    public static void main(String[] args) {
        MyUser aUser = new MyUser("a", 30);
        MyUser bUser = new MyUser("b", 20);
        MyUser cUser = new MyUser("c", 10);

        MyUser[] array = {aUser, bUser, cUser};
        System.out.println("기본 데이터");
        System.out.println(Arrays.toString(array));
        System.out.println("Comparable 기본 정렬");
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        // 추가
        System.out.println("IdComparator 정렬");
        Arrays.sort(array, new IdComparator());
        System.out.println(Arrays.toString(array));

        System.out.println("IdComparator reversed 정렬");
        Arrays.sort(array, new IdComparator().reversed());
        System.out.println(Arrays.toString(array));


    }
}
