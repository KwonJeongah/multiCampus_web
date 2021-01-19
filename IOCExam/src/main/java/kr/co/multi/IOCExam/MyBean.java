package kr.co.multi.IOCExam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyBean {
	public String name;
	private int count;
	
	@Autowired
	private MyDAO myDao;
	
	public void setMyDao(MyDAO myDao) {
		this.myDao = myDao;
	}
	
	public void checkDao() {
		myDao.print();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
}
