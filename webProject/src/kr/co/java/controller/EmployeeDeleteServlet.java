package kr.co.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.java.dao.EmployeeDAO;
import kr.co.java.dao.MemberDAO;

/**
 * Servlet implementation class EmployeeDeleteServlet
 */
@WebServlet("/empDelete")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.요청객체에서 empno 값을 얻어온다.
		String empno = request.getParameter("empno");
		//2.id에 해당하는 member를 DB에서 삭제한다.
		EmployeeDAO dao = new EmployeeDAO();
		int count = dao.deleteEmp(empno);
		//3.empList를 리다이렉트한다. 리다이렉트: 응답이 갔다 오는 것
		if(count!=0)response.sendRedirect("empList");
		else response.sendRedirect("employeeInsertForm.html");
	}

}
