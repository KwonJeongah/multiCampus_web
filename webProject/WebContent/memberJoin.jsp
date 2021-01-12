<%@page import="kr.co.java.dto.MemberDTO"%>
<%@page import="kr.co.java.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입이 완료되었습니다</h1>
입력한 정보 내역입니다:
<%
	request.setCharacterEncoding("utf-8");

	//데이터베이스에 저장
	MemberDAO dao = new MemberDAO();
	MemberDTO member = new MemberDTO();
	member.setId(request.getParameter("id") );
	member.setName(request.getParameter("name"));
	member.setPassword(request.getParameter("pw"));
	member.setEmail(request.getParameter("email"));
	
	if(dao.addMember(member)){
%>
<h2>DB 저장 성공</h2>
<table>
	<tr>
		<td>이름</td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>아이디</td>
		<td><%=request.getParameter("id") %></td>
	</tr>
	<tr>
		<td>비밀번호 </td>
		<td><%=request.getParameter("pw") %></td>
	</tr>
	<tr>
		<td>이메일 </td>
		<td><%=request.getParameter("email") %></td>
	</tr>
</table>
<%}else{%>
<h2>DB 저장 실패</h2>
<button onclick="location.href='memberJoinForm.html'">Return</button>
<%} %>
</body>
</html>