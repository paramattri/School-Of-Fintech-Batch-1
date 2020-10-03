package day4Assignment2;
import java.util.Scanner;
public class Question10PowerOfTwo {
	
	public static void powerOfTwo(int number) {
		
		boolean isPower = false;
		if( (int)Math.floor((Math.log(number) / Math.log(2))) ==  (int)Math.ceil((Math.log(number) / Math.log(2))) )
			isPower = true;
		
		if(isPower)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		if(number < 0) {
			System.out.println("Number too small");
			System.exit(0);
		}
		if(number > 32767) {
			System.out.println("Number too large");
			System.exit(0);
		}
		
		powerOfTwo(number);

	}

}
