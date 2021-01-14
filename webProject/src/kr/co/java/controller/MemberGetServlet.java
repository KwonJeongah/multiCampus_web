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
 * Servlet implementation class memberUpdateServlet
 */
@WebServlet("/memberGet")
public class MemberGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO dao = new MemberDAO();
		MemberDTO member = dao.getMember(request.getParameter("id"));
		
		
		if(member != null) {
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("memberUpdateForm.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("memberList");
		}
		
		
	}

}
