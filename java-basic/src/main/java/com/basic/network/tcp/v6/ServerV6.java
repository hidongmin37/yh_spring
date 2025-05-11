package com.basic.network.tcp.v6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

public class ServerV6 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        SessionManagerV6 sessionManagerV6 = new SessionManagerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        // ShutdownHook 등록
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManagerV6);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook));

        try {

        while (true) {
            Socket socket = serverSocket.accept();
            log("소켓 연결 :" + socket);

            SessionV6 sessionV6 = new SessionV6(socket,sessionManagerV6);
            Thread thread = new Thread(sessionV6);
            thread.start();
        }
        } catch (IOException e) {
            log("서버 소켓 종료 " + e);
        }
    }

    static class ShutdownHook implements Runnable {
        private final ServerSocket serverSocket;
        private final SessionManagerV6 sessionManagerV6;

        public ShutdownHook(ServerSocket serverSocket, SessionManagerV6 sessionManagerV6) {
            this.serverSocket = serverSocket;
            this.sessionManagerV6 = sessionManagerV6;
        }

        @Override
        public void run() {
            log("shutdown hook 실행");
            try {
                sessionManagerV6.closeAll();
                serverSocket.close();
                Thread.sleep(1000); // 자원 정리 대기
                log("자원 정리 종료");
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            } 
        }
    }

}
