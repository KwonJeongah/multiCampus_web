package javaexam;

import org.junit.Test;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {
	Calculator cal;
	
	protected void setUp() throws Exception {
		cal = new Calculator();
		System.out.println("setUp");
	}

	protected void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	public void testAdd() throws Exception{
		int result = cal.add(1, 3);
		assertEquals(4, result);
	}
	
	public void testMinus() throws Exception{
		int result = cal.minus(5, 2);
		assertEquals(3, result);
	}
}
