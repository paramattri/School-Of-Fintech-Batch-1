package dayAssignment3;
import java.util.Scanner;
public class Question5DigitFactorial {
	
	static int factorial[];
	
	public static void digitFactorial(int number) {
		
		int noOfDigits = (int)Math.log10(number) + 1;
		factorial = new int[noOfDigits];
		
		String sNumber = Integer.toString(number);
		char arr[] = sNumber.toCharArray();
		int fact = 1;
		int count = 0;
		
		for(char c : arr) {
			int digit = Character.getNumericValue(c);
			fact = 1;
			for(int i = digit; i > 0; i--) {
				fact *= i;
			}
			factorial[count] = fact;
			count++;
		}
		
		for(int f : factorial)
			System.out.println(f);
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
		
		digitFactorial(number);

	}

}
