package dayAssignment3;
import java.util.Scanner;
public class Question10LargestArray {
	
	static int output[];
	
	public static void largestArray(int arr1[], int arr2[], int n) {
		
		output = new int[n];
		for(int i = 0; i < n; i++) {
			if(arr1[i] > arr2[i])
				output[i] = arr1[i];
			else
				output[i] = arr2[i];
			}
		
		for(int element : output) {
			System.out.println(element);
		}
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n < 0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		int arr1[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
			if(arr1[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		
		int arr2[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
			if(arr2[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		
		largestArray(arr1, arr2, n);
		
	}

}
