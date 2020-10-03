package dayAssignment3;
import java.util.Scanner;
public class Question4ArithmeticOperation {
	
	public static int performArithmeticOperation(int firstNumber, int secondNumber, int operation) {
		
		if(firstNumber < 0 || secondNumber < 0 || firstNumber > 32767 || secondNumber > 32767)
			return -1;
		
		int result;
		switch(operation) {
		case 1:
			result = firstNumber + secondNumber;
			break;
		case 2:
			result = firstNumber - secondNumber;
			break;
		case 3:
			result = firstNumber * secondNumber;
			break;
		case 4:
			result = firstNumber / secondNumber;
			break;
		default:
			return -1;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int firstNumber = sc.nextInt();
		int secondNumber = sc.nextInt();
		int operation = sc.nextInt();
		
		int result = performArithmeticOperation(firstNumber, secondNumber, operation);
		if(result == -1)
			System.out.println("Invalid Input");
		else
			System.out.println(result);

	}

}
