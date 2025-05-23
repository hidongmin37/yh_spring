package com.basic.java.thread.sync;

import static com.basic.java.thread.util.MyLogger.log;

public class BankMain {


    public static void main(String[] args) throws InterruptedException {
        BankAccountV6 account = new BankAccountV6(10000);

        Thread t1 = new Thread(new WithdrawTask(account, 8000), "t1");
        Thread t2 = new Thread(new WithdrawTask(account, 8000), "t2");
        t1.start();
        t2.start();

//        sleep(500);
        log("t1 state : " + t1.getState());
        log("t2 state : " + t2.getState());

        t1.join();
        t2.join();

        log("최종 잔액: " + account.getBalance());

    }
}
