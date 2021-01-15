package kr.co.java.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class TestFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TestFilter() {
    	System.out.println("TestFilter 생성자실행");
    }

	public void destroy() {
		System.out.println("TestFilter destroy 실행");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("TestFilter doFilter before 실행");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		System.out.println("TestFilter doFilter after 실행");
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("TestFilter init 실행");
	}

}
