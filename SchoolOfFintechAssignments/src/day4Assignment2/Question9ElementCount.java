package day4Assignment2;
import java.util.Scanner;
public class Question9ElementCount {
	
	public static int findElementCount(int arr[], int size, int searchElement) {
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(arr[i] == searchElement)
				count++;
		}
		return count;
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
		
		int searchElement = sc.nextInt();
		int count = findElementCount(arr, n, searchElement);
		System.out.println(count);

	}

}
