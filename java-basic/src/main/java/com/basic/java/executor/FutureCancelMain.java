package com.basic.java.executor;

import java.util.concurrent.*;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class FutureCancelMain {

//    private static boolean mayInterruptIfRunning = true;
    private static boolean mayInterruptIfRunning = false; // 작업하고 있는 것은 그대로 둠.

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(new MyTask());
        log("작업 시작");
        log("Future.isCancelled=" + future.isCancelled());
        log("Future.isDone=" + future.isDone());

        // 일정시간 후 작업 취소
        sleep(3000);

        // cancel() 호출
        log("future.cancel("+mayInterruptIfRunning+") 호출");
        boolean cancel = future.cancel(mayInterruptIfRunning);
        log("future.cancel("+mayInterruptIfRunning+") 호출 ,cancel 결과 : " + cancel);

        // 결과 확인
        try {
            log("Future result:" + future.get());
        } catch (CancellationException e) {
            log("Future는 이미 취소 되었습니다.");
        } catch (InterruptedException e) {
            log("인터럽트 발생");
        } catch (ExecutionException e) {
            log("실행 예외 발생");
        }

        executorService.shutdown();
    }

    static class MyTask implements Callable<String> {
        @Override
        public String call() {
            try {
                for (int i = 0; i < 10; i++) {
                    log("작업중 " + i);
                    Thread.sleep(1000); // 1초
                }
            } catch (InterruptedException e) {
                log("인터럽트 발생");
                return "Interrupted";
            }
            return "Complete";
        }

    }
}
