package com.java_basic.thread.sync;

import static com.java_basic.thread.util.MyLogger.log;
import static com.java_basic.thread.util.ThreadUtils.sleep;

public class BankAccountV1 implements BankAccount {
    private int balance; // volatile 사용해도 해결불가

    public BankAccountV1(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public boolean withdraw(int amount) {
        log("거래 시작 : " + getClass().getSimpleName());
        // 잔고가 출금액보다 적으면, 진행 X
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
        log("[출금 완료]");
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
