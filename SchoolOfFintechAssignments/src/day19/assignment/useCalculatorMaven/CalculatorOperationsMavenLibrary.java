package day19.assignment.useCalculatorMaven;

import java.util.Scanner;

import com.manipal.calculatorLibraryMaven.CalculatorMaven;

public class CalculatorOperationsMavenLibrary {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the First Number: ");
		int number1 = sc.nextInt();
		
		System.out.println("Enter the Second Number: ");
		int number2 = sc.nextInt();
		
		System.out.println(CalculatorMaven.addition(number1, number2));
		System.out.println(CalculatorMaven.subtraction(number1, number2));
		System.out.println(CalculatorMaven.multiply(number1, number2));
		System.out.println(CalculatorMaven.division(number1, number2));

	}

}
