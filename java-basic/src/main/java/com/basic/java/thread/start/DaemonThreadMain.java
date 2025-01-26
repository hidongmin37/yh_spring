package com.basic.java.thread.start;

public class DaemonThreadMain {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+": main() start");
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setDaemon(false); // 데몬 스레드 여부, 기본적으로 false, 사용자 스레드가 됨
//        daemonThread.setDaemon(true); // 데몬 스레드 여부, 기본적으로 false, 사용자 스레드가 됨
        daemonThread.start(); // 메인 스레드가 이미 꺼졌으므로,

        System.out.println(Thread.currentThread().getName()+": main() end");
    }

    static class DaemonThread extends Thread{

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+": run() start");

            try {
                Thread.sleep(10000); // 10초간 실행
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            System.out.println(Thread.currentThread().getName()+": run() end");
        }
    }
}
