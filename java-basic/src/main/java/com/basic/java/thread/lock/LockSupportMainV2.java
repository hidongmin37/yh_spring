package com.basic.java.thread.lock;

import java.util.concurrent.locks.LockSupport;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class LockSupportMainV2 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "Thread-1");
        thread.start();

        // 잠시 대기하여 Thread-1이 park 상태로 바뀌도록 시간을 준다.
        sleep(100);
        log("Thread-1 state = " + thread.getState());



    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("parkNanos start");
            LockSupport.parkNanos(2_000_000_000); // 2초,parknanos
            log("parkNanos end , state = " + Thread.currentThread().getState());
            log("interrupted = " + Thread.currentThread().isInterrupted());

        }
    }
}
