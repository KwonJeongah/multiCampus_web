package kr.co.java.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.java.dao.MemberDAO;
import kr.co.java.dto.MemberDTO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인하지 않은 사용자에게는 리스트를 보여주지 않는다.
		//1. 아이디, 비밀번호를 얻어온다
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		HttpSession session = request.getSession();
		//2. DB에 클라이언트에서 보낸 정보와 일치하는 정보가 있는지 확인한다.
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.getMember(id);
		//3. 확인 결과에 따라 처리
		if(member == null) {
			//3-3 해당 아이디가 존재하지 않는 경우
			//회원가입 폼으로 리다이렉트
			// 없는 아이디라서 회원가입을 하라는 메시지를 보여주고 싶다 (상태정보가 유지 - 세션 이용)
			// Session 객체 얻어오기
			
			session.setAttribute("msg", id+"존재하지 않는 아이디입니다. 회원가입하고 이용하세요.");
			response.sendRedirect("memberJoinForm.jsp");
		}
		else if(member != null && member.getPassword().equals(pw)) {
			//3-1 동일한 정보가 있다면 쿠키 생성해서 응답 memberList로 리다이렉트
			
			/**
			 * 세션을 이용한 상태정보 유지
			 */
			session.setAttribute("loginOK", member);
			
			/* 쿠키를 이용한 상태정보 유지
			Cookie cookie = new Cookie("loginOK", member.getId());
			cookie.setPath("/");
			cookie.setMaxAge(-1); //-1: 브라우저가 떠 있는 동안
			response.addCookie(cookie);
			*/
			response.sendRedirect("memberList");
		}else{
			//3-2 아이디는 있으나 비밀번호가 다를 경우
			//로그인 폼으로 리다이렉트
			String msg = URLEncoder.encode("비밀번호를 확인하세요.", "utf-8");
			
			/*
			Cookie cookie = new Cookie("msg", msg);
			cookie.setPath("/");
			cookie.setMaxAge(3);
			response.addCookie(cookie);
			*/
			session = request.getSession();
			session.setAttribute(msg, msg);
			response.sendRedirect("loginForm.jsp");
		}
	}


}
