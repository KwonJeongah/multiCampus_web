package kr.co.java.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.java.dao.EmployeeDAO;
import kr.co.java.dto.EmployeeDTO;

/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/empList")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. DAO에게 memberList를 얻어온다. 
		EmployeeDAO dao = new EmployeeDAO();
		List<EmployeeDTO> empList = dao.getEmpList();
		//2. 얻어온 memberList를 request객체에게 맡긴다. 
		request.setAttribute("empList", empList);
		
		//3. employeeList.jsp로 포워딩한다. 
		RequestDispatcher rd = request.getRequestDispatcher("employeeList.jsp");
		rd.forward(request, response);
	}

}
