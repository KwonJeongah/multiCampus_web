package exam.spring.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import exam.spring.board.dto.Member;

@Mapper
public interface MembersMapper {
	public Member getMember(String id);
	public void addMember(Member member);
	public List<Member> getMembers();
}
