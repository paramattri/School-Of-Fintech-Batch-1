package com.manipal.calculatorLibraryMaven;

public class CalculatorMaven {
	
	public static int addition(int number1, int number2) {
		
		return number1 + number2;
	}
	
	public static int subtraction(int number1, int number2) {
		
		return number1 - number2;
	}
	
	public static int multiply(int number1, int number2) {
		
		return number1 * number2;
	}
	
	public static int division(int number1, int number2) {
		
		int result = -1;
		try {
			result = number1 / number2;
			return result;
		} catch (ArithmeticException e) {
			
			System.out.println("Divison by zero not possible.");
		}	
		return result;		
	}

}
