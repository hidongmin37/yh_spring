package com.basic.webService;

import com.basic.io.member.Member;
import com.basic.io.member.MemberRepository;
import com.basic.was.httpServer.HttpRequest;
import com.basic.was.httpServer.HttpResponse;
import com.basic.was.httpServer.servlet.annotaion.Mapping;

import java.io.IOException;

public class MemberController {
    private final MemberRepository memberRepository;

    public MemberController(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Mapping("/")
    public void home(HttpResponse response) {
        String strHtml = """
                <html><body>
                <h1>회원 관리 시스템</h1>
                <ul>
                <li><a href="/members">회원 목록</a></li>
                <li><a href="/add-member-form">회원 가입</a></li>
                </ul>""";

        response.writeBody(strHtml);
    }

    @Mapping("/members")
    public void members(HttpResponse response) {
        StringBuilder strHtml = new StringBuilder("<html><body><h1>회원 목록</h1><ul>");
        memberRepository.findAll().forEach(member -> {
            strHtml.append("<li>")
                   .append(member.getName())
                   .append(" (")
                   .append(member.getAge())
                   .append(")</li>");
        });
        strHtml.append("<a href=\"/\">홈으로 돌아가기</a>");
        strHtml.append("</ul></body></html>");
        response.writeBody(strHtml.toString());
    }


    @Mapping("/add-member-form")
    public void addMemberForm(HttpResponse response) {
        String strHtml = """
                <html><body>
                <h1>회원 가입</h1>
                <form action="/add-member" method="post">
                    <label>회원 정보를 입력하세요.</label><br>
                    아이디 : <input type="text" name="id"><br>
                    이름: <input type="text" name="name"><br>
                    나이: <input type="number" name="age"><br>
                    <input type="submit" value="가입하기">
                </form>
                <a href="/">홈으로 돌아가기</a>
                </body></html>""";
        response.writeBody(strHtml);
    }

    @Mapping("/add-member")
    public void addMember(HttpRequest request,HttpResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);

        Member member = new Member(id, name, age);
        memberRepository.add(member);

        String strHtml = """
                <html><body>
                <h1>회원 가입 완료</h1>
                <p>회원이 성공적으로 등록되었습니다.</p>
                <a href="/">홈으로 돌아가기</a>
                </body></html>""";

        response.writeBody(strHtml);
    }
}
