<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "error.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${count =  Integer.parseInt(request.getParameter("count"))}
	<c:forEach var = "i" begin="0" end="count" step="1">
		안녕jsp
	</c:forEach>
	
	<%-- 
	<%
		int count = Integer.parseInt(request.getParameter("count"));
	for(int i = 0; i<count; i++){
	%>
		안녕 jsp
		<%=request.getParameter("name") %> <br>
		
	<%
		}
	%>
	--%>
</body>
</html>