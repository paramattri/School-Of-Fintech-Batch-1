package day4Assignment3;
import java.util.Scanner;
public class Question9SumOfOddDigits {
	
	public static int sumOddDigits(int n) {
		
		int noOfDigits = (int)Math.log10(n) + 1;
		int temp = n;
		int sum = 0;
		
		if(n < 0 || n > 32767)
			return -1;
		
		for(int i = 0; i < noOfDigits; i++) {
			int lastDigit = temp % 10;
			if(lastDigit % 2 != 0)
				sum += lastDigit;
			
			temp /= 10;
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int result = sumOddDigits(n);
		if(result == -1)
			System.out.println("Invalid Input");
		else
			System.out.println(result);

	}

}
