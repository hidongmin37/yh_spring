package com.java_basic.thread.sync;

import static com.java_basic.thread.util.MyLogger.log;
import static com.java_basic.thread.util.ThreadUtils.sleep;

public class BankMain {


    public static void main(String[] args) throws InterruptedException {
        BankAccountV3 account = new BankAccountV3(10000);

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
