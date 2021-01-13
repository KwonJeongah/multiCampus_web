package kr.co.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.java.common.DBUtil;
import kr.co.java.dto.EmployeeDTO;

public class EmployeeDAO {
	//삭제
		public int deleteEmp(String empno) {
			int resultCount = 0;
			Connection conn  = null;
			PreparedStatement ps = null;
			
			try {
				conn = DBUtil.getConnection();
				ps = conn.prepareStatement("delete from emp where empno = ?");
				ps.setString(1, empno);
				
				resultCount = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(conn,ps);
			}
			
			return resultCount;
		}
		//입력
		public boolean addEmp(EmployeeDTO emp) {
			boolean resultFlag = false;
			//1. 필요한 객체들을 선언 
			Connection conn = null;
			PreparedStatement ps = null;
			try {
			//3. DB 접속
			conn = DBUtil.getConnection();
			
			//4. 쿼리문 준비
			String sql = "insert into emp(empno, ename, job, mgr, hiredate, sal, comm, deptno)"
					+ "values(?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, emp.getEmpNo());
			ps.setString(2, emp.getEname());
			ps.setString(3, emp.getJob());
			ps.setString(4, emp.getMgr());
			ps.setString(5, emp.getHireDate());
			ps.setInt(6, emp.getSal());
			ps.setInt(7, emp.getComm());
			ps.setInt(8, emp.getDeptNo());
		
			//5. 실행
			int count = ps.executeUpdate(); //select(executeQuery) 제외하고는 update 사용
			if(count == 1) resultFlag = true;
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				//2. 선언한 객체를 닫아주세요.
				DBUtil.close(conn, ps);
			}
			
			return resultFlag;
		}
		
		public List<EmployeeDTO> getEmpList() {
			List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
			
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {				
				conn = DBUtil.getConnection();
				
				String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					EmployeeDTO emp = new EmployeeDTO();	
					emp.setEmpNo(rs.getInt(1));
					emp.setEname(rs.getNString(2));
					emp.setJob(rs.getNString(3));
					emp.setMgr(rs.getNString(4));
					emp.setHireDate(rs.getNString(5));
					emp.setSal(rs.getInt(6));
					emp.setComm(rs.getInt(7));
					emp.setDeptNo(rs.getInt(8));
					
					result.add(emp);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DBUtil.close(conn, ps, rs);
			}
			
			return result;
		}
}
