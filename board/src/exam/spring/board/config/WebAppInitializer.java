package exam.spring.board.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * web.xml
 * DispatcherServlet ��� (Spring 3.2�̻���� ���, web.xml������ �̿��� �����ߴ� �Ͱ� ����)
 * @author USER
 *
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	/**
	 * ���⼭ ���ϵ� @ConfigurationŬ�������� ContextLoaderListener�� ������ ���ø����̼� ���ؽ�Ʈ �����ϴµ� ����
	 * 
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {ApplicationConfig.class}; //ó���� ������ �� �� ������ �о, componentscan��.
	}

	/**
	 * ���⿡�� ���ϵ� Ŭ�������� dispatcherServlet�� ���ø����̼� ���ؽ�Ʈ�� ���� �ɵ��� ����
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class<?>[] {MvcConfig.class};
	}

	/**
	 * �������� ��û�� �ּ� ������ ���� Spring���� ó������ ���� ������ �� �ֵ��� ���ִ� �޼���
	 * return new String[]{"/"};�� ��� ��û�� ���� spring���� ó�����ְڴٴ� �ǹ�
	 * 
	 * �迭����? ��û �ּ� ������ ������ ����� �� �ֵ��� �ϱ� ����
	 */
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
