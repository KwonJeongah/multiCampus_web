package kr.co.multi.IOCExam;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {

	public static void main(String[] args) {
		ApplicationContext context = 
				//new ClassPathXmlApplicationContext("exam.xml");
				new AnnotationConfigApplicationContext(MyBeanConfig.class);
		
		MyBean bean = context.getBean("myBean", MyBean.class);
				
		bean.setName("콩");
		System.out.println(bean.getName());
		
		bean.checkDao();
	}

}
