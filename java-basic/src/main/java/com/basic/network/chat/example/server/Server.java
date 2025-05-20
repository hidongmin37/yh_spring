package com.basic.network.chat.example.server;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class Server {
    private final int port;
    private final SessionManager sessionManager;
    private final CommandManager commandManager;
    private ServerSocket serverSocket;

    public Server(int port, SessionManager sessionManager, CommandManager commandManager) {
        this.port = port;
        this.sessionManager = sessionManager;
        this.commandManager = commandManager;
    }

    public void start() throws IOException {
        log("서버 시작 : " + commandManager.getClass());
        serverSocket = new ServerSocket(port);
        log("서버 소켓 시작 - 리스닝 포트: " + port);

        // 셧다운 훅 등록
        addShutdownHook();

        // 프로그램 작동
        runnig();
    }

    private void runnig() {
        try {
            while (true) {
                Socket accept = serverSocket.accept(); // 블로킹
                log("소켓 연결 :" + accept);
                Session session = new Session(accept, commandManager, sessionManager);
                Thread thread = new Thread(session);
                thread.start();

            }
        } catch (IOException e) {
            log("서버 소켓 종료 " + e);
        }
    }

    private void addShutdownHook() {
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdownHook"));
    }

    static class ShutdownHook implements Runnable {
        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        public ShutdownHook(ServerSocket serverSocket, SessionManager sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            log("shutdown hook 실행");
            try {
                sessionManager.closeAll();
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
