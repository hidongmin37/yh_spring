package com.basic.network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;


// 소켓에 대한 연결은 해주지만 메세지 보냈을때 응답을 안해주는 서버
public class SoTimeoutClient {
    public static void main(String[] args) throws IOException,InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        InputStream input = socket.getInputStream();

        try {
            socket.setSoTimeout(3000); // 3초 대기 뒤에 타임 아웃 시간 설정
            int read = input.read();
            System.out.println("read = " + read);
        }catch (Exception e) {
            e.printStackTrace();
        }
        socket.close();
    }
}
