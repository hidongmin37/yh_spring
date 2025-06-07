package com.basic.was.v5.servlet;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.HttpServlet;

import java.io.IOException;

public class SearchServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String query = request.getParameter("q");
        response.writeBody("<h1>검색 결과</h1>");
        response.writeBody("<p>검색어: " + query + "</p>");
        response.writeBody("<a href=\"/\">홈으로 돌아가기</a>");
    }
}
