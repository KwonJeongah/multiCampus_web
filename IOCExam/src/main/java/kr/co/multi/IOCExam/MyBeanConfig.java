package kr.co.multi.IOCExam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("kr.co.multi") //stereotype(@service, @repository, @controller), @component 어노테이션이 부여된 class를 자동으로 스캔하여 bean으로 등록
public class MyBeanConfig {
	/*
	@Bean
	public MyBean myBean(MyDAO myDao) {
		return new MyBean(myDao);
	}
	
	@Bean
	public MyDAO myDao() {
		return new MyDAO();
	}
	*/
}
