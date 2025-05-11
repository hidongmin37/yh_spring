package com.basic.network.tcp.v2;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ServerV2 {
    
    private static final int PORT = 12345;
    
    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);
        Socket clientSocket = serverSocket.accept(); // 12345번 포트로 접속을 누가 하게되면 소켓을 만들어줌
        log("소켓 연결: " + clientSocket);


        DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

        while (true) {
            // 클라이언트로부터 문자 받기
            String received = dataInputStream.readUTF();
            log("client -> server: " + received);

            if (received.equals("exit")) {
                break;
            }

            // 서버에서 클라이언트로 문자 보내기
            String toSend = received + " World!";
            dataOutputStream.writeUTF(toSend);
            log("server -> client: " + toSend);
        }

        // 자원 정리
        log("연결 종료: " + clientSocket);
        dataInputStream.close();
        dataOutputStream.close();
        clientSocket.close();
        serverSocket.close();
    }
}
