package servlet_mvc.servlet.web.frontController.v1.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.domain.member.Member;
import servlet_mvc.servlet.domain.member.MemberRepository;
import servlet_mvc.servlet.web.frontController.v1.ControllerV1;

import java.io.IOException;


public class MemberSaveControllerV1 implements ControllerV1 {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");

        int userAge = Integer.parseInt(age);
        Member member = new Member(userName, userAge);
        memberRepository.save(member);

        request.setAttribute("member",member);

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request,response);
    }
}
