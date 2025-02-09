package com.basic.java.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static com.basic.java.thread.util.MyLogger.log;

public class BoundedQueueV5 implements BoundedQueue {

    private final Lock lock = new ReentrantLock();
    private final Condition producerCond = lock.newCondition();
    private final Condition consumerCod = lock.newCondition();

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;


    public BoundedQueueV5(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        lock.lock();
        try {
            while (queue.size() == max) {
                log("[put] 큐가 가득 참, 생산자 대기");
                try {
                    producerCond.await();
                    log("[put] 생산자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.offer(data); // 대기 스레드, wait->blocked
            log("[put] 생산자 데이터 저장, consumerCond.signal() 호출");
            consumerCod.signal();
        }finally {
            lock.unlock();
        }

    }


    @Override
    public String take() {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                log("[put] 큐에 데이터가 없음, 소비자 대기");
                try {
                    consumerCod.await();
                    log("[take] 소비자 깨어남");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            String data = queue.poll();
            log("[take] 소비자 데이터 획득, producerCond.signal() 호출");
            producerCond.signal();// 대기 스레드 , wait-> blocked
            return data;
        } finally {
            lock.unlock();
        }

    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
