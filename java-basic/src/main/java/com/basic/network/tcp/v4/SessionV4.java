package com.basic.network.tcp.v4;

import com.basic.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

public class SessionV4 implements Runnable {

    private final Socket socket;

    public SessionV4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // finally 블록에서 변수에 접근해야 한다.
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
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
            log(e);
        } finally {
           SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
           log("연결 종료 : " + socket);
        }

    }


}
