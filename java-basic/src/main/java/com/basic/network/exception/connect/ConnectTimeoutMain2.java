package com.basic.network.exception.connect;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

@Slf4j
public class ConnectTimeoutMain2 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.1.250", 45678), 5000); // 1초 대기
        }
        catch (SocketTimeoutException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        log.info("소요시간: " + (end - start) + "ms");
    }
}
