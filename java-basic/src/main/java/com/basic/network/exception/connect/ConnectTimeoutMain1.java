package com.basic.network.exception.connect;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

@Slf4j
public class ConnectTimeoutMain1 {

    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();

        try {
            Socket socket = new Socket("192.168.1.250", 45678);
        }
        catch (ConnectException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();

        log.info("소요시간: " + (end - start) + "ms");
    }
}
