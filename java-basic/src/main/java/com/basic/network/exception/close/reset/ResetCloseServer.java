package com.basic.network.exception.close.reset;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ResetCloseServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);
        socket.close();
        serverSocket.close();
        log("소켓 종료");
    }
}
