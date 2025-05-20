package com.basic.network.chat.examination;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static com.basic.network.MyLogger.log;

public class ExamChatTestClient {


    private static final int PORT = 12345;
    private static String userName = null; // 초기화 명시

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", PORT);
             DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
             DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        ) {
            // 메시지 수신 스레드 시작
            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String received = dataInputStream.readUTF();
                        System.out.println(received);
                    }
                } catch (IOException e) {
                    log(e);
                }
            });
            receiveThread.setDaemon(true);
            receiveThread.start();

            // 메시지 송신은 메인 스레드에서 처리
            Scanner scanner = new Scanner(System.in);
            while (true) {
                if (userName == null) {
                    System.out.println("채팅방에 입장하기 위해서는 이름을 입력해야 합니다.");
                    userName = scanner.nextLine();
                    dataOutputStream.writeUTF("/join|" + userName);
                } else {
                    System.out.println("메시지 입력 (종료는 /exit):");
                }
                String toSend = scanner.nextLine();

                if (toSend.equals("/exit")) {
                    dataOutputStream.writeUTF(toSend);
                    break;
                } else if (
                        toSend.startsWith("/message|") ||
                        toSend.equals("/users") ||
                        toSend.startsWith("/change|")) {
                    dataOutputStream.writeUTF(toSend);
                } else {
                    System.out.println("잘못된 명령어입니다.");
                }
            }
        } catch (IOException e) {
            log(e);
        }
    }

}
