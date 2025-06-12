package com.basic.was.v8;

import com.basic.was.httpServer.HttpServer;
import com.basic.was.httpServer.HttpServlet;
import com.basic.was.httpServer.ServletManager;
import com.basic.was.httpServer.servlet.DiscardServlet;
import com.basic.was.httpServer.servlet.annotaion.AnnotationServletV3;

import java.io.IOException;
import java.util.List;

public class ServerMainV8 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> controllers = List.of(new SiteControllerV8(), new SearchControllerV8());
//        HttpServlet annotationServlet = new AnnotationServletV2(controllers);
        HttpServlet annotationServlet = new AnnotationServletV3(controllers);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServlet);
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
