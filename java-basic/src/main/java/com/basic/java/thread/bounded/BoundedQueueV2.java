package com.basic.java.thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class BoundedQueueV2 implements BoundedQueue {
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;


    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {

        while (queue.size() == max) {
            log("[put] 큐가 가득 참, 생산자 대기");
            sleep(1000);
        }
        log("[put] 큐가 빠짐, 생산자에서 제공");
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            log("[put] 큐에 데이터가 없음, 소비자 대기");
            sleep(1000);
        }
        log("[put] 큐에 데이터가 있음, 소비자에서 추출");
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
