package com.basic.java.thread.cas;

import java.util.ArrayList;
import java.util.List;

import static com.basic.java.thread.util.ThreadUtils.sleep;

public class IncrementThreadMain {

    public static final int NUM_THREADS = 1000;
    public static void main(String[] args) throws InterruptedException {
        test(new BasicInteger());
        test(new VolatileInteger());
        test(new SyncInteger());
        test(new MyAtomicInteger());
    }

    private static void test(IncrementInteger incrementInteger
    ) throws InterruptedException {
        Runnable runnable =new Runnable() {
            @Override
            public void run() {
                sleep(10); // 너무 빨리 실행되면 쓰레드가 동시에 실행되는 것을 확인하기 어려움
                incrementInteger.increment();
            }
        };
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }

        int result = incrementInteger.get();
        System.out.println(incrementInteger.getClass().getSimpleName() + " : result => " + result);
    }
}
