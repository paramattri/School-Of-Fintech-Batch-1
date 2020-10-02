import java.util.Scanner;
public class Assignment1Question11Kaprekar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number: ");
		int number = sc.nextInt();
		int originalDigits = (int)Math.log10(number) + 1;
		
		int squared = number * number;
		int squaredDigits = (int)Math.log10(squared) + 1;
		String sSquaredNumber = Integer.toString(squared);
		int digitsArray[] = new int[sSquaredNumber.length()];
 		
		for(int i = 0; i < sSquaredNumber.length(); i++) {
			digitsArray[i] = sSquaredNumber.charAt(i) - '0';
		}
		
		int count = 0;
		int leftDigits = squaredDigits - originalDigits;
		int leftNumber = 0, rightNumber = 0;
		
		for(int i = 0; i < digitsArray.length; i++) {
			if(count < leftDigits) {
				leftNumber = leftNumber * 10 + digitsArray[i];
				count++;
			}else {
				rightNumber = rightNumber * 10 + digitsArray[i];
			}
		}
		int sum = leftNumber + rightNumber;
		if(sum == number)
			System.out.println("Kaprekar Number");
		else
			System.out.println("Not A Kaprekar Number");
	}

}
