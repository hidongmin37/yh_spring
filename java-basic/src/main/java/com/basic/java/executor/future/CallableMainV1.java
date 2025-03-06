package com.basic.java.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer>future= es.submit(new MyCallable());
        Integer result = future.get();
        log("result : " + result);
        es.shutdown();
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() {
            log("Callable 실행");
            sleep(2000);
            int value = new Random().nextInt(45);
            log("value : " + value);
            log("Callable 완료");
            return value;
        }
    }
}
