package servlet_mvc.servlet.web.frontController.v2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.domain.member.Member;
import servlet_mvc.servlet.domain.member.MemberRepository;
import servlet_mvc.servlet.web.frontController.MyView;
import servlet_mvc.servlet.web.frontController.v1.ControllerV1;
import servlet_mvc.servlet.web.frontController.v2.ControllerV2;

import java.io.IOException;


public class MemberSaveControllerV2 implements ControllerV2 {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String age = request.getParameter("age");

        int userAge = Integer.parseInt(age);
        Member member = new Member(userName, userAge);
        memberRepository.save(member);

        request.setAttribute("member",member);
        MyView myView = new MyView("/WEB-INF/views/save-result.jsp");
        return myView;

    }
}
