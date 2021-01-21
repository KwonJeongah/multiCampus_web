package exam.spring.board.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exam.spring.board.config.ApplicationConfig;
import exam.spring.board.dto.Member;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class MembersMapperTest {
	@Autowired
	MembersMapper membersMapper;
	
	@Test
	public void getMember() throws Exception{
		Member member = membersMapper.getMember("pinokee24");
		Assert.assertNotNull(member);
		Assert.assertEquals("Á¤¾Æ", member.getName());
	}

	@Test
	public void addMember() throws Exception{
		Member testMember = new Member();
		testMember.setId("test");
		testMember.setPassword("1234");
		testMember.setEmail("test@test.com");
		testMember.setName("testName");
		
		membersMapper.addMember(testMember);
		
		Assert.assertNotNull(membersMapper.getMember("test"));
	}
	
	@Test
	public void getMembers() throws Exception{
		List<Member> memberList = membersMapper.getMembers();
		Assert.assertEquals(7, memberList.size());
	}
	
}
