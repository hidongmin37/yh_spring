package com.basic.java.collection.set.javaset;

import java.util.*;

public class JavaSetMain {

    public static void main(String[] args) {
        Set<String> hash = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();
        run(hash);
        run(linkedHashSet);
        run(treeSet);
    }

    private static void run(Set<String> set) {
        System.out.println("set = " + set.getClass().getSimpleName());
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("C");
        set.add("B");
        set.add("A");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
