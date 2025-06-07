package com.basic.was.httpServer.servlet;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.HttpServlet;

import java.io.IOException;

public class InternalErrorServlet implements HttpServlet {
    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        response.setStatusCode(500);
        response.writeBody("<h1>Internal Server Error</h1>");
    }
}
