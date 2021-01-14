<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//쿠키저장
	String cookieName = request.getParameter("cookieName");
	String cookieValue = request.getParameter("cookieValue");
	
	//쿠키생성
	Cookie cookie = new Cookie(cookieName, cookieValue);
	cookie.setPath("/");//이 쿠키가 어떤 url에서만 유효하게 하겠다.
	cookie.setMaxAge(-1);//초 단위, 쿠키 유지 시간
	
	//쿠키를 응답결과에 표함시켜야 함
	response.addCookie(cookie);
	
	response.sendRedirect("cookieView.jsp");
%>