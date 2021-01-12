<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Email List application</title>
</head>
<body>
<h1>메일 리스트에 가입되었습니다. </h1>
입력한 정보 내역입니다:

<table>
	<tr>
		<td>First Name: </td>
		<td><%=request.getParameter("firstName") %></td>
	</tr>
	<tr>
		<td>Last Name: </td>
		<td><%=request.getParameter("lastName") %></td>
	</tr>
	<tr>
		<td>Email Name: </td>
		<td><%=request.getParameter("email") %></td>
	</tr>
</table>
추가로 메일을 등록하려면 아래 Return 버튼을 클릭하세요.<br>
<button onclieck="location.href='join_email.list.html'">Return</button>
</body>
</html>