package kr.co.java.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class TestFilter2
 */
@WebFilter("/hi")
public class TestFilter2 implements Filter {

	 /**
     * Default constructor. 
     */
    public TestFilter2() {
    	System.out.println("TestFilter2 생성자실행");
    }

	public void destroy() {
		System.out.println("TestFilter2 destroy 실행");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("TestFilter2 doFilter before 실행");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		System.out.println("TestFilter2 doFilter after 실행");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("TestFilter2 init 실행");
	}


}
