<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문 조사 시스템</title>
</head>
<body>
<h1>설문조사가 완료되었습니다.</h1>
설문조사 결과 <br>
<h5>신상 정보</h5>
<table>
	<tr>
		<td>이름: </td>
		<td><%=request.getParameter("name") %></td>
	</tr>
	<tr>
		<td>전화번호: </td>
		<td><%=request.getParameter("number") %></td>
	</tr>
	<tr>
		<td>이메일: </td>
		<td><%=request.getParameter("email") %></td>
	</tr>
</table>

<h5>알게된 경로</h5>
<%=request.getParameter("contactVia") %>

<h5>좋아하는 스포츠</h5>
<%=request.getParameter("sports") %>

<h5>연락 방법</h5>
<%=request.getParameter("connect") %>

<h5>개인정보 활용 동의 여부</h5>
<% if ("agree".equals(request.getParameter("agree"))) {%>
동의합니다.
<%} else{%>
동의하지 않습니다.
<%} %>


</body>
</html>