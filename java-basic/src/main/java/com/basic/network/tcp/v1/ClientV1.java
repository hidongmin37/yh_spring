package com.basic.network.tcp.v1;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ClientV1 {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        /*
        * Socket[addr=localhost/127.0.0.1,port=12345,localport=56576]
        *
        * 남는 포트를 하나 열어서 해줌
        * */
        Socket socket = new Socket("localhost", PORT);
//        socket.getOutputStream(); // 외부에 데이터를 보낼수 있다.
//        socket.getInputStream(); // 외부에서 데이터를 받을수 있다.

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결: " + socket);

        // 서버에 문자 보내기
        String toSend = "Hello";
        dataOutputStream.writeUTF(toSend);
        log("client -> server: " + toSend);

        // 서버로부터 문자 받기
        String received = dataInputStream.readUTF();
        log("server -> client: " + received);

        // 자원 정리
        log("연결 종료: " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();

    }
}
