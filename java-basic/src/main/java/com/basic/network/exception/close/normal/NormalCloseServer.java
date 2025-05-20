package com.basic.network.exception.close.normal;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class NormalCloseServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();

        log("소켓 연결: " + socket);
        Thread.sleep(1000); // 1초
        socket.close(); // 소켓을 닫음 , 클라이언트에 FIN 패킷을 보냄
        log("소켓 종료");

    }
}
