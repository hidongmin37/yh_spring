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
import java.util.List;


public class MemberListControllerV2 implements ControllerV2 {
    MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members",members);

        MyView myView = new MyView("/WEB-INF/views/members.jsp");
        return myView;

    }


}
