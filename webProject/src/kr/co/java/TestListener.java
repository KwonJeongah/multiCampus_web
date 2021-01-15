package kr.co.java;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class TestListener implements ServletContextListener {
	
    public TestListener() {
    	System.out.println("TestListener 생성자 실행");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("TestListener contextDestroyed 실행");
    }

    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("TestListener contextInitialized 실행");
    }
	
}
