<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#msg {
	color: red;
}
</style>
</head>
<body>
<%
	String msg = (String)session.getAttribute("msg");
	session.removeAttribute("msg");
%>

<%
	if(msg!=null){
%>
	<div id="msg" class =" a test bb"><%=msg %></div>
<%} %>

<h1>회원가입</h1>
<form action="memberJoin" method="get">
이름: <input type='text' name='name'><br>
아이디: <input type='text' name='id'><br>
비밀번호: <input type='text' name='pw'><br>
이메일: <input type='text' name='email'><br>
<input type="submit" value="Submit">
</form>
</body>
</html>