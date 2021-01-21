package exam.spring.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration //어노테이션 기반 환경구성을 돕는다.
@EnableWebMvc //어노테이션 기반의 SpringMVC를 구성할 때 필요한 Bean 설정을 자동으로 해줌.
@ComponentScan(basePackages = "exam.spring.board.controller")
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	
}
