<%@ page import="servlet_mvc.servlet.domain.member.Member" %>
<%@ page import="servlet_mvc.servlet.domain.member.MemberRepository" %><%--
  Created by IntelliJ IDEA.
  User: hidongmin37
  Date: 10/9/23
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // request, response 는 그냥 사용 가능
    MemberRepository memberRepository = MemberRepository.getInstance();
    String userName = request.getParameter("userName");
    String age = request.getParameter("age");

    System.out.println("userName = " + userName);
    System.out.println("age = " + age);
    int userAge = Integer.parseInt(age);
    Member member = new Member(userName, userAge);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id=<%= member.getId()%></li>
    <li>userName=<%= member.getUserName()%></li>
    <li>age=<%= member.getAge()%></li>
</ul>
<a href="/index.html">
메인
</a>
</body>
</html>
