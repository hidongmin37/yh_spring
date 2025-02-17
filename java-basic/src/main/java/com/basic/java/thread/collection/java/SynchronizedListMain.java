package com.basic.java.thread.collection.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListMain {
    public static void main(String[] args) {
        // Collections.synchronizedList에는  synchronized proxy가 있음 -> SynchronizedRandomAccessList
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        list.add("data1");
        list.add("data2");
        list.add("data3");
        list.add("data4");

        System.out.println(list.getClass());
        System.out.println("list = " + list);
    }
}
