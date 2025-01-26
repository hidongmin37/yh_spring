package com.basic.java.collection.deque.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    private static Map<Product, Integer> map = new HashMap<>();


    public void add(Product product,int count) {
        Integer orDefault = map.getOrDefault(product, 0);
        map.put(product, orDefault + count);

    }

    public void minus(Product product,int count) {
        Integer orDefault = map.getOrDefault(product, 0);
        int newQuantity = orDefault - count;
        if (newQuantity <= 0) {
            map.remove(product);
        }
    }


    public void printAll() {
        System.out.println(" == 모든 상품 출력 ==");
        Set<Map.Entry<Product, Integer>> entries = map.entrySet();
        for (Map.Entry<Product, Integer> entry : entries) {
            System.out.println("Product = " + entry.getKey() + " Count = " + entry.getValue());
        }
    }

}
