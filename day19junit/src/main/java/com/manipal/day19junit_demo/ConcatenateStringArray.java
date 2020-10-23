package com.manipal.day19junit_demo;

public class ConcatenateStringArray {

	public String[] concatenateArray(String arr1[], String arr2[]) {
		
		int totalLength = arr1.length + arr2.length;
		String[] finalArray = new String[totalLength];
		
		System.arraycopy(arr1, 0, finalArray, 0, arr1.length);
		System.arraycopy(arr2, 0, finalArray, arr1.length, arr2.length);
		
		return finalArray;
	}
}
