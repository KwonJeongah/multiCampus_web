<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int count = Integer.parseInt(request.getParameter("count"));
	for(int i = 0; i<count; i++){
	%>
		안녕 jsp
		<%=request.getParameter("name") %> <br>
		
	<%
		}
	%>
</body>
</html>