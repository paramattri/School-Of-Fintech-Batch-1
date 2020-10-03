package dayAssignment3;
import java.util.Scanner;
public class Question1CountOf3Multiples {
	
	public static int divisibleBy3(int arr[], int size) {
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(arr[i] % 3 == 0)
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
		
		int count = divisibleBy3(arr, n);
		System.out.println(count);

	}

}
