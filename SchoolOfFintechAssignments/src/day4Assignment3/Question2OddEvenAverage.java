package day4Assignment3;
import java.util.Scanner;
public class Question2OddEvenAverage {
	
	public static float avgOddEvenSum(int arr[], int size) {
		
		int oddSum = 0;
		int evenSum = 0;
		
		for(int i = 0; i < size; i++) {
			if(arr[i] % 2 == 0) {
				evenSum += arr[i];
			}else
				oddSum += arr[i];
		}
		
		float avg = (float)(evenSum + oddSum) / 2;
		return avg;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n < 0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		
		float avg = avgOddEvenSum(arr,n);
		System.out.printf("%.2f",avg);
		
	}

}
