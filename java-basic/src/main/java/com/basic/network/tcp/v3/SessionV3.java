package com.basic.network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

public class SessionV3 implements Runnable {

    private final Socket socket;

    public SessionV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
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

            log("연결 종료: " + socket);
            dataInputStream.close();
            dataOutputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}
