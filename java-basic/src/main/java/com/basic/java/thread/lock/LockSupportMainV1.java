package com.basic.java.thread.lock;

import java.util.concurrent.locks.LockSupport;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread = new Thread(new ParkTest(), "Thread-1");
        thread.start();

        // 잠시 대기하여 Thread-1이 park 상태로 바뀌도록 시간을 준다.
        sleep(100);
        log("Thread-1 state = " + thread.getState());

        log("unpark start ");
        LockSupport.unpark(thread); // park 상태를 풀어준다.
        log("unpark end ");
//        thread.interrupt(); // park 상태를 풀어준다.
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            log("park start");
            LockSupport.park();
            log("park end , state = " + Thread.currentThread().getState());
            log("interrupted = " + Thread.currentThread().isInterrupted());

        }
    }
}
