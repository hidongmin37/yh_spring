package com.basic.java.thread.bounded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static com.basic.java.thread.util.MyLogger.log;

public class BoundedQueueV6_3 implements BoundedQueue {

    private static final Logger log = LoggerFactory.getLogger(BoundedQueueV6_3.class);
    private BlockingQueue<String> queue;

    public BoundedQueueV6_3(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        try {
            //대기 시간 설정 가능
            boolean result = queue.offer(data,1, TimeUnit.NANOSECONDS);
            log("저장 시도 결과 =" + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public String take() {
        try {
            //대기 시간 설정 가능
            return queue.poll(2,TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "BoundedQueueV6_1{" +
                "queue=" + queue +
                '}';
    }
}
