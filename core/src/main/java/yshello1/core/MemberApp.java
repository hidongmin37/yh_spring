package yshello1.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import yshello1.core.member.Grade;
import yshello1.core.member.Member;
import yshello1.core.member.MemberService;
import yshello1.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
      /*  AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();*/
//        MemberService memberService = new MemberServiceImpl();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //annotaion기반으로 컨피그 설정
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// appConfig에서 뭘 찾냐랑, 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
