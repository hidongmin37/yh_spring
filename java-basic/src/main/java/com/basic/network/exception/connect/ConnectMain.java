package com.basic.network.exception.connect;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectMain {
    public static void main(String[] args) throws IOException {
//        unKnownHostException();
        unKnownHostException2();
//        connectionRefusedException();
    }

    private static void unKnownHostException() throws IOException {
        try {
            Socket socket = new Socket("999.999.999.999", 80);
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }

    private static void unKnownHostException2() throws IOException {
        try {
            Socket socket = new Socket("google.gogo", 80);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }


    /**
     * 접속까지는 되었으나,
     * 포트를 사용하지 않기 때문에
     * TCP 연결이 거부됨
     * */
    private static void connectionRefusedException() throws IOException {
        try {
            Socket socket = new Socket("localhost", 12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
