package com.java_basic.thread.control;

import com.java_basic.thread.util.ThreadUtils;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class CheckedRunnable implements Runnable {
        @Override
        public void run()  {
//                throws Exception {
//            throw new Exception();
//             throws InterruptedException {
//            Thread.sleep(3000); 주석 풀면 예외 발생
            ThreadUtils.sleep(1000);
        }

        // 부모 메서드가 체크 예외를 던지지 않는 경우, 재정의된 자식 메소드도
        // 체크 예외를 던질 수 없다.
        // 자식 메서드는 부모 메소드가 던질 수 있는 체크 예외의 하위타입만 던질 수 있다.
        // 런타임 예외는 제외
    }
}
