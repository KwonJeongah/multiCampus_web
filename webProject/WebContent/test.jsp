<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public void test(){
	
	}
%>
<%
	/* 자바 주석 String name = null; 서블릿이 실행될 때 주석의 역할을 함 */
	String test = null;
	Enumeration<String> names = request.getParameterNames();

	while(names.hasMoreElements()){
		String name = names.nextElement();
		out.print(names.nextElement()+"<br>");
	}
%>

<%-- jsp 주석: jsp는 서블릿으로 바뀜, 
jsp > 서블릿으로 바뀔 대, 주석안에 있는 것은 서블릿으로 바뀌지 않음 --%>
<!-- <div>안녕~~~</div> html 주석, 
응답결과 포함. 응답까지 들어옴. 브라우저가 화면에 띄울 때 주석 처리-->
</body>
</html>