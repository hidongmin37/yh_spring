
package com.basic.was.v4;

import com.basic.java.thread.util.MyLogger;
import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

import static com.basic.network.MyLogger.log;

@Slf4j
public class HttpRequestHandlerV4 implements Runnable {
    private final Socket socket;

    public HttpRequestHandlerV4(Socket socket) {
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
            HttpRequest request = new HttpRequest(reader);
            HttpResponse response = new HttpResponse(writer);

            if (request.getPath().contains("/favicon.ico")) {
                MyLogger.log("파비콘 요청 무시");
                return;
            }

            MyLogger.log("HTTP 요청 정보 출력 ");
            System.out.println(request);

            MyLogger.log("HTTP 응답 생성 중...");

            if (request.getPath().startsWith("/site1")) {
                site1(response);
            } else if (request.getPath().startsWith("/site2")) {
                site2(response);
            } else if (request.getPath().startsWith("/search")) {
                search(request, response);
            } else if (request.getPath().startsWith("/")) {
                home(response);
            } else {
                notFound(response);
            }
            response.flush();
            MyLogger.log("HTTP 응답 완료");
        }
    }

    private void notFound(HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("<h1>Page Not Found</h1>");
    }

    private void site1(HttpResponse response) {

        response.writeBody("<h1>Site 1</h1>");
        response.writeBody("<p>이곳은 사이트 1입니다.</p>");
        response.writeBody("<a href=\"/\">홈으로 돌아가기</a>");
    }

    private void site2(HttpResponse response) {

        response.writeBody("<h1>Site 2</h1>");
        response.writeBody("<p>이곳은 사이트 2입니다.</p>");
        response.writeBody("<a href=\"/\">홈으로 돌아가기</a>");

    }

    private void search(HttpRequest request,HttpResponse response) {
        String query = request.getParameter("q");
        response.writeBody("<h1>검색 결과</h1>");
        response.writeBody("<p>검색어: " + query + "</p>");
        response.writeBody("<a href=\"/\">홈으로 돌아가기</a>");
    }

    private void home(HttpResponse response) {
        // 원칙적으로는 content-length를 구해야 하지만, 간단하게 처리

        response.writeBody("\r\n");
        response.writeBody("<h1>Home Page</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href=\"/site1\">Site 1</a></li>");
        response.writeBody("<li><a href=\"/site2\">Site 2</a></li>");
        response.writeBody("<li><a href=\"/search\\?q=장동민\">Search</a></li>");
        response.writeBody("</ul>");
    }

}
