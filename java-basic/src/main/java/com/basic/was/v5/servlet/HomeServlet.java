package com.basic.was.v5.servlet;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.HttpServlet;

public class HomeServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.writeBody("\r\n");
        response.writeBody("<h1>Home Page</h1>");
        response.writeBody("<ul>");
        response.writeBody("<li><a href=\"/site1\">Site 1</a></li>");
        response.writeBody("<li><a href=\"/site2\">Site 2</a></li>");
        response.writeBody("<li><a href=\"/search\\?q=장동민\">Search</a></li>");
        response.writeBody("</ul>");
    }
}
