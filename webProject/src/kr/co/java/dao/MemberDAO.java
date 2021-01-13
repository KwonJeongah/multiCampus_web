package kr.co.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.java.common.DBUtil;
import kr.co.java.dto.MemberDTO;

public class MemberDAO {
	//멤버 삭제
	public int deleteMember(String id) {
		int resultCount = 0;
		Connection conn  = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("delete from members where id = ?");
			ps.setString(1, id);
			
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn,ps);
		}
		
		return resultCount;
	}
	//입력
	public boolean addMember(MemberDTO member) {
		boolean resultFlag = false;
		//1. 필요한 객체들을 선언 
		Connection conn = null;
		PreparedStatement ps = null;
		try {
		//3. DB 접속
		conn = DBUtil.getConnection();
		
		//4. 쿼리문 준비
		String sql = "insert into members(id, name, password, email, join_date) values (?,?,?,?,sysdate)";
		ps = conn.prepareStatement(sql);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPassword());
		ps.setString(4, member.getEmail());
		
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
	
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> result = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			result = new ArrayList<MemberDTO>();
			
			conn = DBUtil.getConnection();
			
			String sql = "select id, name, password, join_date, email from members";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setJoinDate(rs.getString(4));
				member.setEmail(rs.getString(5));
				result.add(member);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		
		return result;
	}

	
	public static void main(String[] args) {
		MemberDAO dao = new MemberDAO();
		/*
		MemberDTO member = new MemberDTO();
		member.setId("carami");
		member.setName("강경미");
		member.setPassword("1111");
		member.setEmail("carami@nate.com");
		
		System.out.println(dao.addMember(member));
		*/
		
		/*
		List<MemberDTO> members = dao.getMemberList();
		for(MemberDTO memberDTO:members) {
			System.out.println(memberDTO);
		}
		*/
		
		System.out.println(dao.deleteMember("pinokee24"));
	}
}
