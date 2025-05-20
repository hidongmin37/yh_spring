package com.basic.network.chat.example.client;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static com.basic.network.MyLogger.log;
import static com.basic.network.tcp.SocketCloseUtil.closeAll;

@Slf4j
public class Client {
    private final String host;
    private final int port;

    private Socket socket;

    private DataInputStream input;
    private DataOutputStream output;

    private ReadHandler readHandler;
    private WriteHandler writeHandler;


    private boolean closed = false;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() throws IOException {
        log("클라이언트 시작");
        socket = new Socket(host, port);
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());

        readHandler = new ReadHandler(input, this);
        writeHandler = new WriteHandler(output, this);

        Thread readThread = new Thread(readHandler, "readHandler");
        Thread writeThread = new Thread(writeHandler, "writeHandler");
        readThread.start();
        writeThread.start();
    }

    public void close() {
        if (closed) {
            return;
        }

        closed = true;
        writeHandler.close();
        readHandler.close();
        closeAll(socket,input, output);
        log("연결 종료 : " + socket + " isClosed: " + socket.isClosed());
    }
}
