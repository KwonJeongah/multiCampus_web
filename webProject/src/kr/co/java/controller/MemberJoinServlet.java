package kr.co.java.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.java.dao.MemberDAO;
import kr.co.java.dto.MemberDTO;

@WebServlet("/memberJoin")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//데이터베이스에 저장
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id") );
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("pw"));
		member.setEmail(request.getParameter("email"));
		
		//DB저장이 성공여부에 따라서 다른 결과를 보여주고 싶었다
		boolean resultFlag = dao.addMember(member);
		//request.setAttribute("resultFlag", resultFlag);
		//RequestDispatcher rd = request.getRequestDispatcher("memberJoin.jsp");
		//rd.forward(request, response);
		if(resultFlag) response.sendRedirect("memberList");
		else response.sendRedirect("memberJoinForm.html");
		/*
		//포워딩을 도와주는 객체
		RequestDispatcher rd = null;
		
		if(resultFlag) {
			rd = request.getRequestDispatcher("memberJoinOk.jsp");
		}else {
			rd = request.getRequestDispatcher("memberJoinFail.jsp");
		}
		
		rd.forward(request, response);*/
	}
	

}
