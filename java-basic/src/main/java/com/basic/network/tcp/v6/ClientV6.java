package com.basic.network.tcp.v6;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static com.basic.network.MyLogger.log;

@Slf4j
public class ClientV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        // finally 블록에서 변수에 접근해야 한다.
        // 따라서 try 블록 안에서 선언할 수 없다.
        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        ) {
            log("소켓 연결: " + socket);

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

        } catch (IOException e) {
            log(e);
        }

    }
}
