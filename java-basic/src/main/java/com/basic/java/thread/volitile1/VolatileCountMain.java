package com.basic.java.thread.volitile1;

import static com.basic.java.thread.util.MyLogger.log;
import static com.basic.java.thread.util.ThreadUtils.sleep;

public class VolatileCountMain {

    public static void main(String[] args) {
        MyTask task = new MyTask();
        Thread thread = new Thread(task, "work");
        thread.start();
        sleep(1000);
        task.flag = false;
        log("flag = " + task.flag + ", count = " + task.count + ", out while");
        log("main 종료");

    }

    static class MyTask implements Runnable {
//        boolean flag = true;
//        long count = 0;;;

        // volatile 키워드를 붙이면, 속도가 거의 4배 느려진다
        volatile boolean flag = true;
        volatile long count = 0;

        @Override
        public void run() {
            while (flag) {
                count++;
                // 1억번에 한번씩 출력
                if (count % 100_000_000 == 0) {
                    log("flag = " + flag + ", count = " + count + ",  in while");
                }
            }
            log("flag = " + flag + ", count = " + count + ", out while");
        }
    }
}
