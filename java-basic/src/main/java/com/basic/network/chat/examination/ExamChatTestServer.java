package com.basic.network.chat.examination;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

public class ExamChatTestServer {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ExamChatSessionManager sessionManager = new ExamChatSessionManager();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결 :" + socket);

                ExamSession examSession = new ExamSession(socket,sessionManager);
                Thread thread = new Thread(examSession);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료 " + e);
        }
    }

}