package com.basic.java.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class CallableMainV2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("== submit 전 ==");
        Future<Integer>future= es.submit(new MyCallable());
        log("== submit 호출 후 ==");
        log("future = " + future);
        log("future.get() [blocking] 호출 시작 => 메인 스레드 Waiting");
        Integer result = future.get();
        log("future.get() [blocking] 호출 완료 => 메인 스레드 Runnable 실행");
        log("== future 즉시 반환 == , future = " + future);

        log("result : " + result);
        log("future 완료 : " + future);
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
