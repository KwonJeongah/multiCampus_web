<%@page import="java.net.URLDecoder"%>
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
	String msg = null;
	Cookie[] cookies = request.getCookies();
	if(cookies != null){
		for(Cookie cookie: cookies){
			if("msg".equals(cookie.getName())){
				msg = URLDecoder.decode(cookie.getValue(), "UTF-8");
				break;
			}
		}
	}
%>
<h1>로그인</h1>
<%
	if(msg!=null){
%>
	<div id="msg"><%=msg %></div>
<%} %>
<form action="login" method = "post">
	아이디: <input type = "text" name = "id"><br>
	비밀번호 : <input type = "password" name = "pw"><br>
	<input type ="submit" value = "로그인"><input type = "reset" value ="취소">
</form>
</body>
</html>