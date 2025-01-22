package com.java_basic.thread.sync;

import static com.java_basic.thread.util.MyLogger.log;
import static com.java_basic.thread.util.ThreadUtils.sleep;

public class BankAccountV2 implements BankAccount {
    private int balance;

    public BankAccountV2(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public synchronized boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());
        // 잔고가 출금액보다 적으면, 진행 X

        // == 임계 영역 시작 ==
        log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
        if (balance < amount) {
            log("[검증 실패]");
            return false;
        }
        // 잔고가 많아야 진행
        log("[검증 완료]");
        sleep(1000); //출금에 걸리는 시간
        balance = balance - amount;
        log("[출금 완료] 출금액 : " + amount + ", 잔액 : " + balance);
        // == 임계 영역 종료 ==


        log("[출금 완료]");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
