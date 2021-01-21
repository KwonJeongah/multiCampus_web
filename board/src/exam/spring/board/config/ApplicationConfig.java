package exam.spring.board.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration //설정파일에는 @Configuration 붙이기
@ComponentScan(basePackages = {"exam.spring.board.dao","exam.spring.board.service"}) //Bean 직접 등록 대신 componentscan 사용
@Import({MyBatisConfig.class}) //mybatisconfig안의 bean이 여기에 들어 있는 것처럼 실행됨 -> 나누는 이유? 나중에 프레임워크 바뀌었을 경우, mybatis만 바꾸면 됨
public class ApplicationConfig {
	@Bean
	public DataSource dataSource() { //db에 접속할 수 있는 정보
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class); //나는 드라이버 클래스가 이거야
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("TIGER");
		return dataSource;
	}
}
