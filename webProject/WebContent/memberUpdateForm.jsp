<%@page import="kr.co.java.dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberDTO member =(MemberDTO) request.getAttribute("member");
%>
<h1>회원수정</h1>
	      <form action="memberUpdate" method="post">
            <table>
            <tr>
                    <td>아이디:</td>
                    <td><input type="text" name="id"
					value="<%=member.getId()%>" readonly="readonly"></td>
                </tr>
                <tr>
                    <td>이름:</td>
                    <td><input type="text" name="name" value="<%=member.getName()%>"></td>
                </tr>
                
                <tr>
                    <td>비밀번호:</td>
                    <td><input type="password" name="pw" value="<%=member.getPassword()%>"></td>
                </tr>
                <tr>
                    <td>이메일:</td>
                    <td><input type="email" name="email" value="<%=member.getEmail()%>"></td>
                </tr>
            </table>
            <input type="submit" value="Submit">
        </form>
</body>
</html>