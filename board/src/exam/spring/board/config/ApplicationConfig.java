package exam.spring.board.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration //�������Ͽ��� @Configuration ���̱�
@ComponentScan(basePackages = {"exam.spring.board.dao","exam.spring.board.service"}) //Bean ���� ��� ��� componentscan ���
@Import({MyBatisConfig.class}) //mybatisconfig���� bean�� ���⿡ ��� �ִ� ��ó�� ����� -> ������ ����? ���߿� �����ӿ�ũ �ٲ���� ���, mybatis�� �ٲٸ� ��
public class ApplicationConfig {
	@Bean
	public DataSource dataSource() { //db�� ������ �� �ִ� ����
		SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
		dataSource.setDriverClass(oracle.jdbc.driver.OracleDriver.class); //���� ����̹� Ŭ������ �̰ž�
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("TIGER");
		return dataSource;
	}
}
