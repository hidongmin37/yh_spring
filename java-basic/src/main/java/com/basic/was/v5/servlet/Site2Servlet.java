package com.basic.was.v5.servlet;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.HttpServlet;

import java.io.IOException;

public class Site2Servlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {

        response.writeBody("<h1>Site 2</h1>");
        response.writeBody("<p>이곳은 사이트 2입니다.</p>");
        response.writeBody("<a href=\"/\">홈으로 돌아가기</a>");
    }
}
