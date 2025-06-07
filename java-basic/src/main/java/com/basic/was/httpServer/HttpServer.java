package com.basic.was.httpServer;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.basic.java.thread.util.MyLogger.log;

@Slf4j
public class HttpServer {
    private final int port;
    private ExecutorService executorService = Executors.newFixedThreadPool(10);
    private ServletManager servletManager;

    public HttpServer(int port, ServletManager servletManager) {
        this.port = port;
        this.servletManager = servletManager;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        log("서버 시작 port: " + port);
        while (true) {
            Socket socket = serverSocket.accept();
            executorService.submit(new HttpRequestHandler(socket,servletManager));
        }

    }
}
