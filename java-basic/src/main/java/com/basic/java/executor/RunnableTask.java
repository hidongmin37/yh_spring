package com.basic.java.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class RunnableTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(RunnableTask.class);
    private final String name;
    private int sleepMs = 1000;

    public RunnableTask(String name) {
        this.name = name;
    }

    public RunnableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        log(name + " 시작");
        sleep(sleepMs); // 작업시간 시뮬레이션
        log(name + " 완료");
    }
}
