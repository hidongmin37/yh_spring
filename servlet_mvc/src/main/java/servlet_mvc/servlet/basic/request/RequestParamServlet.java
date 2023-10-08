package servlet_mvc.servlet.basic.request;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/*
* 1.파라미터 전송기능
*  http://localhost:8080/request-param?userName=hello&age=20*/
@WebServlet(name = "requestPramServlet" , urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("RequestParamServlet.service");

        System.out.println("[전체 파라미터 조회] - 시작");
        request.getParameterNames().asIterator().forEachRemaining(paramName -> System.out.println( paramName + " = " + request.getParameter(paramName)));

        System.out.println("[전체 파라미터 조회] - 종료");

        System.out.println("[단일 파라미터 조회] - 시작");
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");
        System.out.println("userName = " + userName);
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - 종료");
        System.out.println("[이름이 같은 복수 파라미터 조회] - 시작");
        String[] userNames = request.getParameterValues("userName"); // 중복 이름
        for (String username : userNames) {
            System.out.println("userName = " + username);
        }
        System.out.println("[이름이 같은 복수 파라미터 조회] - 종료");

        response.getWriter().write("Ok");




    }
}
