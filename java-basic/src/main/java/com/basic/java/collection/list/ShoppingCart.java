package com.basic.java.collection.list;

import java.util.ArrayList;

public class ShoppingCart {

    private static ArrayList<Item> cart = new ArrayList<>();

    public void addItem(Item item) {
        cart.add(item);
    }

    public void displayItems() {
        System.out.println("장바구니 상품 출력");
        int sum = 0;
        for (Item item : cart) {
            System.out.println("상품명:" + item.getName()+", 합계:" +item.getTotalPrice() );
            sum += item.getTotalPrice();
        }

        System.out.println("전체 가격 합:"+sum);
    }

}
