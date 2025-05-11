package com.basic.network.exception.connect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


// 소켓에 대한 연결은 해주지만 메세지 보냈을때 응답을 안해주는 서버
public class SoTimeoutServer {
    public static void main(String[] args) throws IOException,InterruptedException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Socket accept = serverSocket.accept();// 클라이언트가 접속할때까지 대기


        Thread.sleep(100000); // 100초 대기
    }
}
