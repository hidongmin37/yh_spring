package com.basic.was.v5;

import com.basic.was.httpServer.HttpServer;
import com.basic.was.httpServer.ServletManager;
import com.basic.was.httpServer.servlet.DiscardServlet;
import com.basic.was.v5.servlet.HomeServlet;
import com.basic.was.v5.servlet.SearchServlet;
import com.basic.was.v5.servlet.Site1Servlet;
import com.basic.was.v5.servlet.Site2Servlet;

import java.io.IOException;

public class ServletMainV5 {
    private static final int PORT = 12312;
    public static void main(String[] args) throws IOException {
        ServletManager servletManager = new ServletManager();
        servletManager.add("/", new HomeServlet());
        servletManager.add("/site1", new Site1Servlet());
        servletManager.add("/site2",new Site2Servlet());
        servletManager.add("/search",new SearchServlet());
        servletManager.add("/favicon.ico",new DiscardServlet());

        HttpServer httpServer = new HttpServer(PORT, servletManager);
        httpServer.start();

    }
}
