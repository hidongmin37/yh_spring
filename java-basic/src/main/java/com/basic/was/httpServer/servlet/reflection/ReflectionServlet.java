package com.basic.was.httpServer.servlet.reflection;

import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.HttpServlet;
import com.basic.was.httpServer.PageNotFoundException;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

public class ReflectionServlet implements HttpServlet {

    private final List<Object> controllers;

    public ReflectionServlet(List<Object> controllers) {
        this.controllers = controllers;
    }


    @Override
    public void service(HttpRequest request, HttpResponse response) throws IOException {
        String path = request.getPath();


        for (Object controller : controllers) {
            Class<?> clazz = controller.getClass();
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method : declaredMethods) {
                String methodName = method.getName();
                if (path.equals("/" + methodName)) {
                    invoke(controller, method, request, response);
                    return;
                }
            }

        }
        throw new PageNotFoundException("request: " + path + " not found");
    }

    private static void invoke(Object controller, Method method, HttpRequest request, HttpResponse response) {
        try {
            // 메소드 호출
            method.setAccessible(true); // private 메소드 접근 허용
            method.invoke(controller,request, response);
        } catch (Exception e) {
            response.writeBody("<h1>Internal Server Error</h1>");
        }
    }
}
