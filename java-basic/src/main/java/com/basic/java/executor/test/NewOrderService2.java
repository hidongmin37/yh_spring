package com.basic.java.executor.test;

import java.util.List;
import java.util.concurrent.*;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class NewOrderService2 {
    public void order(String orderNo) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        InventoryWork inventoryWork = new InventoryWork(orderNo);
        ShippingWork shippingWork = new ShippingWork(orderNo);
        AccountingWork accountingWork = new AccountingWork(orderNo);
// 작업 요청
        Future<Boolean> future1 = executorService.submit(inventoryWork);
        Future<Boolean> future2 = executorService.submit(shippingWork);
        Future<Boolean> future3 = executorService.submit(accountingWork);
        try {
            future1.get();
            future2.get();
            future3.get();
            log("모든 주문 처리가 성공적으로 완료되었습니다.");
        } catch (InterruptedException | ExecutionException e) {
            log("일부 작업이 실패했습니다.");
        }

// 결과 확인


        executorService.shutdown();
    }
    static class InventoryWork implements Callable<Boolean> {
        private final String orderNo;

        public InventoryWork(String orderNo) {
            this.orderNo = orderNo;
        }

        @Override
        public Boolean call() {
            log("재고 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class ShippingWork implements Callable<Boolean> {
        private final String orderNo;
        public ShippingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("배송 시스템 알림: " + orderNo);
            sleep(1000);
            return true;
        }
    }
    static class AccountingWork implements Callable<Boolean> {
        private final String orderNo;
        public AccountingWork(String orderNo) {
            this.orderNo = orderNo;
        }
        @Override
        public Boolean call() {
            log("회계 시스템 업데이트: " + orderNo);
            sleep(1000);
            return true;
        }
    }
}

