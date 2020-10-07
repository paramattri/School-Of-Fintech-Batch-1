package day7Assignment1;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		float div;
		
		//if(args[0] == null && args[1] == null)
			//System.out.println("No Input Received");
		
		try {
			int first = Integer.parseInt(args[0]);
			int second = Integer.parseInt(args[1]);
			div = (float)first / second;
			System.out.println(div);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No Input Received");
		}
		catch(NumberFormatException e) {
			System.out.println("Only Integers are allowed");
		}
		catch(ArithmeticException e) {
			System.out.println("Divsion with zero is not possible");
		}
		
		
		
		

	}

}
