package com.basic.java.executor.test;

public class OrderServiceTestMain {
    public static void main(String[] args) {
        String orderNo = "Order#1234"; // 예시 주문 번호

//        OldOrderService orderService = new OldOrderService();
//        NewOrderService orderService = new NewOrderService();
        NewOrderService2 orderService = new NewOrderService2();
        orderService.order(orderNo);
    }
}
