package com.basic.was.v2;

import com.basic.java.thread.util.MyLogger;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static com.basic.network.MyLogger.log;

@Slf4j
public class HttpRequestHandlerV2 implements Runnable {
    private final Socket socket;

    public HttpRequestHandlerV2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process();
        }
        catch (Exception e) {
            log(e);
        }
    }

    private void process() throws IOException {
        try (socket;
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), false, StandardCharsets.UTF_8)

        ) {
            String requestString = requestToString(reader);

            if (requestString.contains("/favicon.ico")) {
                MyLogger.log("파비콘 요청 무시");
                return;
            }

            MyLogger.log("HTTP 요청 정보 출력 ");
            System.out.println(requestString);

            MyLogger.log("HTTP 응답 생성 중...");

            sleep(5000); // 응답 생성 시간 시뮬레이션

            responseToClient(writer);
            MyLogger.log("HTTP 응답 완료");
        }
    }

    private static String requestToString(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
            if (line.isEmpty()) {
                break;
            }
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    private void responseToClient(PrintWriter writer) {
        // 웹 브라우저에 전달하는 내용
        String body = "<h1>Hello World</h1>";
        int length = body.getBytes(StandardCharsets.UTF_8).length;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 200 OK\r\n");
        stringBuilder.append("Content-Type: text/html;charset=utf-8\r\n");
        stringBuilder.append("Content-Length: ").append(length).append("\r\n");
        stringBuilder.append("\r\n"); // 헤더와 바디 구분
        stringBuilder.append(body);

        MyLogger.log("HTTP 응답 정보 출력");
        System.out.println(stringBuilder);

        writer.println(stringBuilder);
        writer.flush();// 실제 전송이 된다. 오토플러시 false라서
    }
    private void sleep(int millis) {
        try {
            Thread.sleep(millis); // 서버 처리시간
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
