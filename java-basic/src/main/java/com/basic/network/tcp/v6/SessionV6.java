package com.basic.network.tcp.v6;

import com.basic.network.tcp.SocketCloseUtil;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;

public class SessionV6 implements Runnable {


    private final Socket socket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final SessionManagerV6 sessionManagerV6;
    private boolean closed = false;

    public SessionV6(Socket socket,SessionManagerV6 sessionManagerV6) throws IOException {
        this.socket = socket;
        this.sessionManagerV6 = sessionManagerV6;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.sessionManagerV6.add(this);
    }

    @Override
    public void run() {
        // finally 블록에서 변수에 접근해야 한다.

        try{

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
        } finally {
            sessionManagerV6.remove(this);
            close();
        }

        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

    // 세션 종료시, 서버 종료시 동시에 호출될 수 있다.
    public synchronized void close() {
        if (closed) {
            return;
        }
        SocketCloseUtil.closeAll(socket, dataInputStream, dataOutputStream);
        closed = true;
        log("연결 종료: " + socket + " isClosed: " + socket.isClosed());
    }

}
