package kr.co.multi.IOExam.tv.user;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.multi.IOExam.tv.TV;


public class TVUser {
	public static void main(String[] args) {
		System.out.println("ApplicationContext 생성 전");
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("ApplicationContext 생성 후");
		TV tv = factory.getBean("j", TV.class); //TV 클래스로 가져와줘 
		// getBean: DL
		
		tv.turnOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.turnOff();
	}
}
