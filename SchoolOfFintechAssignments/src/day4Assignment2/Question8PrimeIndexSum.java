package day4Assignment2;
import java.util.Scanner;
public class Question8PrimeIndexSum {
	
	public static int primeIndexSum(int array[], int size) {
		
		int count = 0;
		int sum = 0;
		boolean isPrime;
		int avg;
		
		for(int i = 0; i < size; i++) {
			isPrime = true;
			for(int j = 2; j * j <= (i + 1); j++) {
				if((i + 1) % j == 0) {
					isPrime = false;
					break;
				}
			}
			if(i == 0)
				isPrime = false;
			if(isPrime) {
				count++;
				sum += array[i];
			}
		}
		
		avg = sum / count;
		return avg;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 0) {
			System.out.println("Invalid Array Size");
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
		
		 int avg = primeIndexSum(arr, n);
		 System.out.println(avg);

	}

}
