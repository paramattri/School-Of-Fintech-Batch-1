package com.manipal.calculatorLibraryMaven;

import org.junit.Test;

import com.manipal.calculatorlibrarymaven.CalculatorMaven;

import junit.framework.TestCase;

public class CalculatorMavenTest extends TestCase {
	
	@Test
	public void testAddition() {
		
		int actual = CalculatorMaven.addition(5, 10);
		int expected = 15;
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testSubtraction() {
		
		int actual = CalculatorMaven.subtraction(10, 5);
		int expected = 5;
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testSubtraction1() {
		
		int actual = CalculatorMaven.subtraction(5, 10);
		int expected = -5;
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testMultiply() {
		
		int actual = CalculatorMaven.multiply(10, 5);
		int expected = 50;
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testDivision() {
		
		int actual = CalculatorMaven.division(10, 5);
		int expected = 2;
		assertEquals(expected, actual);				
	}
	
	@Test
	public void testDivision1() {
		
		float actual = CalculatorMaven.division(10, 0);
		float expected = -1f;
		assertEquals(expected, actual);				
	}
		
}
