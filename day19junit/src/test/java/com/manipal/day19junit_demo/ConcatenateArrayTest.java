package com.manipal.day19junit_demo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcatenateArrayTest {
	
	@Test
	public void testConcatenateArray() {
		
		ConcatenateStringArray obj = new ConcatenateStringArray();
		String[] arr1 = {"Param","Attri"};
		String[] arr2 = {"Java","Kotlin"};
		
		String[] actuals = obj.concatenateArray(arr1, arr2);
		String[] expecteds = {"Param","Attri","Java","Kotlin"};
		assertArrayEquals(expecteds, actuals);
	}

}
