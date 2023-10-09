package servlet_mvc.servlet.web.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet_mvc.servlet.domain.member.Member;
import servlet_mvc.servlet.domain.member.MemberRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {

    MemberRepository memberRepository = MemberRepository.getInstance();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Member> members = memberRepository.findAll();

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<html>\n");
        writer.write("<head>\n");
        writer.write("    <meta charset=\"UTF-8\">\n");
        writer.write("    <title>Title</title>\n");
        writer.write("</head>\n");
        writer.write("<body>\n");
        writer.write("<a href=\"/index.html\">메인</a>\n");
        writer.write("<table>\n");
        writer.write("    <thead>\n");
        writer.write("    <th>id</th>\n");
        writer.write("    <th>username</th>\n");
        writer.write("    <th>age</th>\n");
        writer.write("    </thead>\n");
        writer.write("    <tbody>\n");
        //        writer.write("    <tr>\n");
//        writer.write(" <td>1</td>\n");
//        writer.write("<td>userA</td>\n");
//        writer.write("     <td>10</td>\n");
//        writer.write("    </tr>\n");

        for (Member member : members) {
            writer.write("    <tr>");
            writer.write(" <td>" + member.getId() + "</td>\n");
            writer.write(" <td>" + member.getUserName() + "</td>\n");
            writer.write(" <td>" + member.getAge() + "</td>\n");
            writer.write("    /<tr>");
        }
        writer.write("    </tbody>\n");
        writer.write("</table>\n");
        writer.write("</body>\n");
        writer.write("</html>\n");
    }
}
