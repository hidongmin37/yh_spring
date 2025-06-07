package com.basic.was.httpServer.servlet;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.HttpServlet;

public class NotFoundServlet implements HttpServlet {

    @Override
    public void service(HttpRequest request, HttpResponse response) {
        response.setStatusCode(404);
        response.writeBody("<h1>Page Not Found</h1>");
    }
}
