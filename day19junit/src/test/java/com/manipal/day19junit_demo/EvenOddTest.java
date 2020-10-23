package com.manipal.day19junit_demo;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

public class EvenOddTest {
	
	EvenOdd evenOdd;
	
	@Before
	public void setUp() {
		evenOdd = new EvenOdd();
	}
	
	@Test
	public void testEven(){
		
		String actual = evenOdd.evenOdd(8);
		String expected = "even";
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testOdd(){
		
		String actual = evenOdd.evenOdd(11);
		String expected = "odd";
		assertEquals(expected, actual);		
	}
	
	@Test
	public void testArray() {
		
		int actuals[] = {2,3,8,10};
		int expecteds[] = {2,3,8,10};
		assertArrayEquals(expecteds, actuals);
	}
	

}
