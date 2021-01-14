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

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); //post방식일 때 

		//데이터베이스에 저장
		MemberDAO dao = new MemberDAO();
		MemberDTO member = new MemberDTO();
		member.setId(request.getParameter("id") );
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("pw"));
		member.setEmail(request.getParameter("email"));
		member.setJoinDate(request.getParameter("join_date"));
		
		//DB저장이 성공여부에 따라서 다른 결과를 보여주고 싶었다
		dao.updateMember(member);
		
		response.sendRedirect("memberList");
	}

}
