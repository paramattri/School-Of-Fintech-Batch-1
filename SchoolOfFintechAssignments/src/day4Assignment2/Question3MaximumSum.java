package day4Assignment2;
import java.util.Scanner;
public class Question3MaximumSum {
	
	public static int maximumSum(int numbers[],int size) {
		int sumEven = 0, sumOdd = 0;
		int max = 0;
		for(int i = 0; i < size; i++) {
			if(numbers[i] % 2 == 0) {
				sumEven += numbers[i];
			}else
				sumOdd += numbers[i];
		}
		
		max = Math.max(sumEven, sumOdd);
		return max;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n < 0) {
			System.out.println("Invalid Array Size");
			System.exit(0);
		}
		
		int numbers[] = new int[n];
		for(int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
			if(numbers[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		
		int max;
		max = maximumSum(numbers, n);
		System.out.println(max);	

	}

}
