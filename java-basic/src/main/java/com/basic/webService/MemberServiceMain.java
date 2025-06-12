package com.basic.webService;

import com.basic.io.member.impl.FilMemberRepository;
import com.basic.was.httpServer.HttpServer;
import com.basic.was.httpServer.ServletManager;
import com.basic.was.httpServer.servlet.DiscardServlet;
import com.basic.was.httpServer.servlet.annotaion.AnnotationServletV3;

import java.util.List;

public class MemberServiceMain {

    private static final int PORT = 12345;

    public static void main(String[] args) {
        FilMemberRepository filMemberRepository = new FilMemberRepository();
        MemberController memberController = new MemberController(filMemberRepository);
        AnnotationServletV3 annotationServletV3 = new AnnotationServletV3(List.of(memberController));
        ServletManager servletManager = new ServletManager();
        servletManager.setDefaultServlet(annotationServletV3);
        servletManager.add("/favicon.ico", new DiscardServlet());


        HttpServer httpServer = new HttpServer(PORT, servletManager);
        try {
            httpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
