package dayAssignment3;
import java.util.Scanner;
public class Question3DecimalConversion {
	
	public static int convertToDecimal(int binary) {
		
		if(binary < 0 || binary > 11111) {
			return -1;
		}
		
		int noOfDigits = (int)Math.log10(binary) + 1;
		String binaryString = Integer.toString(binary);
		char arr[] = binaryString.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(!(arr[i] == '0' || arr[i] == '1'))
				return -1;
		}
		
		int decimal = 0;
		int count = 0;
		for(int i = noOfDigits - 1; i >= 0; i--) {
			decimal = decimal + Character.getNumericValue(arr[count]) * (int)Math.pow(2, i);
			count++;
		}
		
		return decimal;
		
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int binary = sc.nextInt();
		
		int result = convertToDecimal(binary);
		
		if(result == -1)
			System.out.println("Invalid Input");
		else
			System.out.println(result);
		

	}

}
