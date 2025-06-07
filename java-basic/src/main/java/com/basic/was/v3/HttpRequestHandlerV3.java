package com.basic.was.v3;

import com.basic.java.thread.util.MyLogger;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

import static com.basic.network.MyLogger.log;

@Slf4j
public class HttpRequestHandlerV3 implements Runnable {
    private final Socket socket;

    public HttpRequestHandlerV3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (Exception e) {
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

            if (requestString.startsWith("GET /site1")) {
                site1(writer);
            } else if (requestString.startsWith("GET /site2")) {
                site2(writer);
            } else if (requestString.startsWith("GET /search")) {
                search(writer, requestString);
            } else if (requestString.startsWith("GET / ")) {
                home(writer);
            } else {
                notFound(writer);
            }

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


    private void notFound(PrintWriter writer) {
        writer.println("HTTP/1.1 404 Not Found");
        writer.println("Content-Type: text/html;charset=utf-8");
        writer.println("\r\n");
        writer.println("<h1>404 Not Found</h1>");
        writer.println("<p>요청하신 페이지를 찾을 수 없습니다.</p>");
    }

    private void site1(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html;charset=utf-8");
        writer.println("\r\n");
        writer.println("<h1>Site 1</h1>");
        writer.println("<p>이곳은 사이트 1입니다.</p>");
        writer.println("<a href=\"/\">홈으로 돌아가기</a>");
    }

    private void site2(PrintWriter writer) {
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html;charset=utf-8");
        writer.println("\r\n");
        writer.println("<h1>Site 2</h1>");
        writer.println("<p>이곳은 사이트 2입니다.</p>");
        writer.println("<a href=\"/\">홈으로 돌아가기</a>");

    }

    private void search(PrintWriter writer,String requestToString) {
        int startIndex = requestToString.indexOf("q=");
        int endIndex = requestToString.indexOf(" ", startIndex +2);
        String query = requestToString.substring(startIndex + 2, endIndex);
        String decode = URLDecoder.decode(query, StandardCharsets.UTF_8);
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html;charset=utf-8");
        writer.println("\r\n");
        writer.println("<h1>검색 결과</h1>");
        writer.println("<p>검색어: " + query + "</p>");
        writer.println("<p>디코딩된 검색어: " + decode + "</p>");
        writer.println("<a href=\"/\">홈으로 돌아가기</a>");
        writer.flush();
    }

    private void home(PrintWriter writer) {
        // 원칙적으로는 content-length를 구해야 하지만, 간단하게 처리
        writer.println("HTTP/1.1 200 OK");
        writer.println("Content-Type: text/html;charset=utf-8");
        writer.println("\r\n");
        writer.println("<h1>Home Page</h1>");
        writer.println("<ul>");
        writer.println("<li><a href=\"/site1\">Site 1</a></li>");
        writer.println("<li><a href=\"/site2\">Site 2</a></li>");
        writer.println("<li><a href=\"/search\\?q=장동민\">Search</a></li>");
        writer.println("</ul>");
    }

}
