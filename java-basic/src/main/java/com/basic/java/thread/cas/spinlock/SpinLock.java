package com.basic.java.thread.cas.spinlock;


import java.util.concurrent.atomic.AtomicBoolean;

import static com.basic.java.thread.util.MyLogger.log;

public class SpinLock {

    private final AtomicBoolean lock = new AtomicBoolean(false);

    public void lock() {
        log("락 획득 시도");

        while (!lock.compareAndSet(false, true)) {
            // 락을 획득할때 까지 스핀 대기(바쁜대기)한다.
            log("락 획득실패 - 스핀대기");

        }
        log("락 획득 완료");
    }

    public void unlock() {
        lock.set(false);
        log("락 반납 완료");
    }
}
