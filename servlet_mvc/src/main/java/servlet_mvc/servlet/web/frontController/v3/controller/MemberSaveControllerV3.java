package servlet_mvc.servlet.web.frontController.v3.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.domain.member.Member;
import servlet_mvc.servlet.domain.member.MemberRepository;
import servlet_mvc.servlet.web.frontController.ModelView;
import servlet_mvc.servlet.web.frontController.MyView;
import servlet_mvc.servlet.web.frontController.v2.ControllerV2;
import servlet_mvc.servlet.web.frontController.v3.ControllerV3;

import java.io.IOException;
import java.util.Map;


public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String userName = paramMap.get("userName");
        int age = Integer.parseInt(paramMap.get("age"));
        Member member = new Member(userName, age);
        memberRepository.save(member);
        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);
        return modelView;

    }
}
