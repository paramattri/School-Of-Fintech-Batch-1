package day4Assignment2;
import java.util.Scanner;
public class Question4ProductOfDigits {
	
	public static int productDigits(int number) {
		
		if(number < 0 || number > 32767)
			return -1;
		
		int product = 1;
		int noOfDigits = (int)Math.log10(number) + 1;
		int temp = number;
		for(int i = 0; i < noOfDigits; i++) {
			product *= (temp % 10);
			temp /= 10;
		}
		return product;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int productOfDigits;
		
		productOfDigits = productDigits(n);
		if(productOfDigits == -1)
			System.out.println("Invalid Input");
		else
			System.out.println(productOfDigits);
	}

}
