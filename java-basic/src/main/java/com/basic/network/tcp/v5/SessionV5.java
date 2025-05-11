package com.basic.network.tcp.v5;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

@Slf4j
public class SessionV5 implements Runnable {

    private final Socket socket;

    public SessionV5(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // finally 블록에서 변수에 접근해야 한다.

        try(socket;
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());) {

            while (true) {
                // 클라이언트로부터 문자 받기
                String received = dataInputStream.readUTF();
                System.out.println("client -> server: " + received);

                if (received.equals("exit")) {
                    break;
                }

                // 서버에서 클라이언트로 문자 보내기
                String toSend = received + " World!";
                dataOutputStream.writeUTF(toSend);
                System.out.println("server -> client: " + toSend);
            }
        } catch (IOException e) {
            log(e);
        }

        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }


}
