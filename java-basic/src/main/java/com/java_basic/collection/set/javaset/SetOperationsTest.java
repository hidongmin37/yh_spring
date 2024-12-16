package com.java_basic.collection.set.javaset;

import java.util.HashSet;
import java.util.List;

public class SetOperationsTest {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(List.of(1, 2, 3, 4, 5));
        HashSet<Integer> set2 = new HashSet<>(List.of(3,4,5));

//        set1.addAll(set2);
//        System.out.println("합집합" + set1);

//        set1.retainAll(set2);
//        System.out.println("교집합" + set2);

        set1.removeAll(set2);
        System.out.println("차집합 " + set1);

    }
}
