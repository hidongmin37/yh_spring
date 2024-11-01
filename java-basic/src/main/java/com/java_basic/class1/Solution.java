package com.java_basic.class1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList<>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println("list1 = " + list1);
		list1.remove(0);
		list1.remove(Integer.valueOf(3));
		System.out.println("list1 = " + list1);

		int size = list1.size();
		System.out.println("size = " + size);

		boolean contains = list1.contains(2);
		System.out.println("contains = " + contains);

		int i = list1.indexOf(2);
		System.out.println("i = " + i);

		// 1-2 LinkedList
		System.out.println("==========" + "LinkedList" + "===========");
		LinkedList linkedList = new LinkedList();
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add("hi");

		System.out.println("linkedList = " + linkedList);

		linkedList.addFirst(4);
		System.out.println("linkedList = " + linkedList);
		linkedList.addLast(5);
		System.out.println("linkedList = " + linkedList);
		linkedList.removeFirst();
		System.out.println("linkedList = " + linkedList);
		linkedList.removeLast();
		System.out.println("linkedList = " + linkedList);
		linkedList.remove(Integer.valueOf(3));
		System.out.println("linkedList = " + linkedList);
		linkedList.remove("hi");
		System.out.println("linkedList = " + linkedList);
		System.out.println("linkedList.size() = " + linkedList.size());

		// 2. Set
		System.out.println("==========" + "HashSet" + "===========");
		HashSet<Object> hashSet = new HashSet<>();
		hashSet.add(1);
		hashSet.add(2);
		hashSet.add(3);
		System.out.println("hashSet = " + hashSet);
		hashSet.remove(2);
		System.out.println("hashSet = " + hashSet);

		// 2-1 TreeSet
		System.out.println("==========" + "treeSet" + "===========");

		TreeSet<Object> treeSet = new TreeSet<>();
		treeSet.add(1);
		treeSet.add(2);
		treeSet.add(3);
		treeSet.add(10);
		treeSet.add(10);
		treeSet.add(15);
		System.out.println("treeSet = " + treeSet);
		Object lower = treeSet.lower(15);
		Object higher = treeSet.higher(2);
		System.out.println("lower = " + lower);
		System.out.println("higher = " + higher);
		Object first = treeSet.first();
		System.out.println("first = " + first);

		System.out.println("==========" + "treeMap" + "===========");
		TreeMap<Object, Object> treeMap = new TreeMap<>();
		treeMap.put(1, "kiwi");
		treeMap.put(2, "apple");
		treeMap.put(3, "mango");
		System.out.println("treeMap = " + treeMap);
		System.out.println("treeMap.firstEntry() = " + treeMap.firstEntry());
		System.out.println("treeMap.firstKey() = " + treeMap.firstKey());
		System.out.println("treeMap.lastEntry() = " + treeMap.lastEntry());



	}

}
