package com.basic.java.executor.future;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static com.basic.java.thread.util.MyLogger.log;

public class InvokeAllMain {


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CallableTask task1 = new CallableTask("task1", 1000);
        CallableTask task2 = new CallableTask("task2", 1000);
        CallableTask task3 = new CallableTask("task3", 1000);

        List<CallableTask> tasks = List.of(task1, task2, task3);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        // invokeAll은 모든 작업이 끝나야 반환한다.

        for (Future<Integer> future : futures) {
            Integer value = future.get();
            log("value = " + value);
        }
        executorService.shutdown();
    }


}
