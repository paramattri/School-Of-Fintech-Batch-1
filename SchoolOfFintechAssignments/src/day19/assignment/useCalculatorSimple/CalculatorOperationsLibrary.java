package day19.assignment.useCalculatorSimple;

import java.util.Scanner;

import com.manipal.library.calculatorSimple.CalculatorSimple;

public class CalculatorOperationsLibrary {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the First Number: ");
		int number1 = sc.nextInt();
		
		System.out.println("Enter the Second Number: ");
		int number2 = sc.nextInt();
		
		CalculatorSimple calculator = new CalculatorSimple();
		System.out.println(calculator.addition(number1, number2));
		System.out.println(calculator.subtraction(number1, number2));
		System.out.println(calculator.multiply(number1, number2));
		System.out.printf("%.2f", calculator.division(number1, number2));
	}

}
