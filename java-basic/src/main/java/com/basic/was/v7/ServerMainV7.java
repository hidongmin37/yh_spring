package com.basic.was.v7;

import com.basic.was.httpServer.HttpServer;
import com.basic.was.httpServer.HttpServlet;
import com.basic.was.httpServer.ServletManager;
import com.basic.was.httpServer.servlet.DiscardServlet;
import com.basic.was.httpServer.servlet.annotaion.AnnotationServletV1;

import java.io.IOException;
import java.util.List;

public class ServerMainV7 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV7(), new SearchControllerV7());
        HttpServlet annotationServlet = new AnnotationServletV1(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
