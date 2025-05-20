package com.basic.network.chat.example.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;
import static com.basic.network.tcp.SocketCloseUtil.closeAll;

public class Session implements Runnable {
    private final Socket socket;
    private final DataInputStream dataInputStream;
    private final DataOutputStream dataOutputStream;
    private final CommandManager commandManager;
    private final SessionManager sessionManager;

    private boolean closed = false;

    private String userName;

    public Session(Socket socket, CommandManager commandManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.commandManager = commandManager;
        this.sessionManager = sessionManager;
        this.dataInputStream = new DataInputStream(socket.getInputStream());
        this.dataOutputStream = new DataOutputStream(socket.getOutputStream());
        this.sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = dataInputStream.readUTF();
                log("client -> server: " + received);

                // 메시지를 전체에게 전송
                commandManager.execute(received, this); // IOException 발생 시 종료
            }

        } catch (Exception e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(userName + "님이 채팅방에서 나가셨습니다.");
            close();
        }
    }


    public void close() {
        if (closed) {
            return;
        }
        closeAll(socket, dataInputStream, dataOutputStream);
        closed = true;
        log("연결 종료 : " + socket);
    }

    public void send(String message) throws IOException {
        log("server -> client: " + message);
        dataOutputStream.writeUTF(message);
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
