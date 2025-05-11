package com.basic.network.tcp.v2;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ClientV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        Socket socket = new Socket("localhost", PORT);
        log("소켓 연결: " + socket);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("전송 문자 :");
            String toSend = scanner.nextLine();
            // 서버에 문자 보내기
            dataOutputStream.writeUTF(toSend);
            log("client -> server: " + toSend);

            if (toSend.equals("exit")) {
                break;
            }

            // 서버로부터 문자 받기
            String received = dataInputStream.readUTF();
            log("server -> client: " + received);
        }
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();


    }
}
