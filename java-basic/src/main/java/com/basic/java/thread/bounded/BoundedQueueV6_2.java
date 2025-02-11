package com.basic.java.thread.bounded;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.basic.java.thread.util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private static final Logger log = LoggerFactory.getLogger(BoundedQueueV6_2.class);
    private BlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        log("저장 시도 결과 =" + result);

    }

    @Override
    public String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return "BoundedQueueV6_1{" +
                "queue=" + queue +
                '}';
    }
}
