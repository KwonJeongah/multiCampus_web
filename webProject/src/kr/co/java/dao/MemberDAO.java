package kr.co.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.java.common.DBUtil;
import kr.co.java.dto.MemberDTO;

public class MemberDAO {
	//로그인
	public boolean loginMember(String id, String pw) {
		boolean resultFlag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			ps = conn.prepareStatement("select * from members where id = ? and password = ?");
			ps.setNString(1,  id);
			ps.setNString(2, pw);
			
			rs = ps.executeQuery();
			
			if(rs!=null) resultFlag = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(conn, ps);
		}
		
		return resultFlag;
	}
	//멤버 하나만
	public MemberDTO getMember(String id) {
		MemberDTO member = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.getConnection();
			
			ps = conn.prepareStatement("select * from members where id = ?" );
			ps.setString(1, id);
					
			rs = ps.executeQuery();
			
			while(rs.next()) {
				member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setPassword(rs.getString("password"));
				member.setEmail(rs.getString("email"));
				member.setJoinDate(rs.getString("join_date"));
				member.setName(rs.getString("name"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		
		return member;
	}
	//멤버 수정
	public int updateMember(MemberDTO member) {
		int resultCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DBUtil.getConnection();
			
			String id = member.getId();
			String name = member.getName();
			String pw = member.getPassword();
			String email = member.getEmail();
			String date = member.getJoinDate();
			
			ps = conn.prepareStatement("update members set name = ?, password = ?, email = ? where id = ?" );
			ps.setNString(1, name);
			ps.setNString(2, pw);
			ps.setNString(3, email);
			ps.setNString(4, id);
			
			resultCount = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps);
		}
		
		return resultCount;
	}
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
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		//1. 필요한 객체 선언 
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//3. DB접속
			conn = DBUtil.getConnection();
			//4. 쿼리작성
			ps = conn.prepareStatement("select id,name,password,email,join_date from members");
			//5. 쿼리실행
			rs = ps.executeQuery();
			//6. 결과값을 꺼내기!! 
			while(rs.next()) {
				MemberDTO member = new MemberDTO();
				member.setId(rs.getString("id"));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setEmail(rs.getString(4));
				member.setJoinDate(rs.getString(5));
				
				memberList.add(member);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			//2. 선언한 객체 닫기!!
			DBUtil.close(conn, ps, rs);
		}
		return memberList;
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
		
		MemberDTO member = dao.getMember("changsuk");
		System.out.println(member);
		
		
	}
}
