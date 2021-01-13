<%@page import="kr.co.java.dto.EmployeeDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
<%
	List<EmployeeDTO> empList = (List<EmployeeDTO>)request.getAttribute("empList");
%>
<H1>사원 목록 </H1>
<table>
	<tr>
		<th>사원번호</th>
		<th>사원이름</th>
		<th>직업</th>
		<th>매니저</th>
		<th>고용일</th>
		<th>임금</th>
		<th>공통</th>
		<th>부서번호</th>
	</tr>
	<% if(empList != null){
	for(EmployeeDTO emp:empList){ %>
	<tr>
		<td><%=emp.getEmpNo() %></td>
		<td><%=emp.getEname() %></td>
		<td><%=emp.getJob() %></td>
		<td><%=emp.getMgr() %></td>
		<td><%=emp.getHireDate() %></td>
		<td><%=emp.getSal() %></td>
		<td><%=emp.getComm() %></td>
		<td><%=emp.getDeptNo() %></td>
		
		<td><a href='empDelete?empno=<%=emp.getEmpNo() %>'>삭제</a></td>
	</tr>
	
	<%} //end for
	}//end if %>
</table>
</body>
</html>