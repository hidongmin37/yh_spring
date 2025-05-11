package com.basic.network.tcp.v4;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static com.basic.network.MyLogger.log;
import static com.basic.network.tcp.SocketCloseUtil.closeAll;

@Slf4j
public class ClientV4 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        // finally 블록에서 변수에 접근해야 한다.
        // 따라서 try 블록 안에서 선언할 수 없다.
        Socket socket = null;
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;
        try {
            socket = new Socket("localhost", PORT);
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
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
        } finally {
            closeAll(socket,dataInputStream, dataOutputStream);
        }



    }
}
