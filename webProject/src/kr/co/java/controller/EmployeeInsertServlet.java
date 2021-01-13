package kr.co.java.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.java.dao.EmployeeDAO;
import kr.co.java.dao.MemberDAO;
import kr.co.java.dto.EmployeeDTO;
import kr.co.java.dto.MemberDTO;

/**
 * Servlet implementation class EmployeeInsertServlet
 */
@WebServlet("/empInsert")
public class EmployeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");

		//데이터베이스에 저장
		EmployeeDAO dao = new EmployeeDAO();
		EmployeeDTO emp = new EmployeeDTO();
		
		emp.setEmpNo(Integer.parseInt(request.getParameter("empno")));
		emp.setEname(request.getParameter("ename"));
		emp.setJob(request.getParameter("job"));
		emp.setMgr(request.getParameter("mgr"));
		emp.setHireDate(request.getParameter("hiredate"));
		emp.setSal(Integer.parseInt(request.getParameter("sal")));
		emp.setComm(Integer.parseInt(request.getParameter("comm")));
		emp.setDeptNo(Integer.parseInt(request.getParameter("deptno")));
		
		//DB저장이 성공여부에 따라서 다른 결과를 보여주고 싶었다
		boolean resultFlag = dao.addEmp(emp);
		
		if(resultFlag) response.sendRedirect("empList");
		else response.sendRedirect("employeeInsertForm.html");
		
	}

}
