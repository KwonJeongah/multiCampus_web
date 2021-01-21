package exam.spring.board.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web.xml
 * DispatcherServlet 등록 (Spring 3.2이상부터 등록, web.xml파일을 이용해 설정했던 것과 동일)
 * @author USER
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * 여기서 리턴된 @Configuration클래스들은 ContextLoaderListener가 생성한 애플리케이션 컨텍스트 설정하는데 도움
	 * 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {ApplicationConfig.class}; //처음에 들어왔을 때 이 설정을 읽어서, componentscan함.
	}

	/**
	 * 여기에서 리턴된 클래스들은 dispatcherServlet의 애플리케이션 컨텍스트에 대한 핀들을 정의
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {MvcConfig.class};
	}

	/**
	 * 브라우저가 요청한 주소 패턴을 보고 Spring에서 처리할지 말지 결정할 수 있도록 해주는 메서드
	 * return new String[]{"/"};면 모든 요청에 대해 spring에서 처리해주겠다는 의미
	 * 
	 * 배열형식? 요청 주소 패턴을 여러개 등록할 수 있도록 하기 위함
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
