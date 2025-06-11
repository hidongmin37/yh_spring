package com.basic.was.v6;

import com.basic.was.httpServer.HttpServer;
import com.basic.was.httpServer.ServletManager;
import com.basic.was.httpServer.servlet.DiscardServlet;
import com.basic.was.httpServer.servlet.reflection.ReflectionServlet;
import com.basic.was.v5.servlet.HomeServlet;

import java.io.IOException;
import java.util.List;

public class ServerMainV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        List<Object> objects = List.of(new SiteControllerV6(), new SearchControllerV6());
        ReflectionServlet reflectionServlet = new ReflectionServlet(objects);

        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(reflectionServlet);
        servletManager.add("/", new HomeServlet());
        servletManager.add("/favicon.ico", new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();
    }
}
