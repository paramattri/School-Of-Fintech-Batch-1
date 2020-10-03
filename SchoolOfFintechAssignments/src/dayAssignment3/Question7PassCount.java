package dayAssignment3;
import java.util.Scanner;
public class Question7PassCount {
	
	public static int passCount(int arr[], int size) {
		
		int count = 0;
		for(int i = 1; i < size; i = i + 2) {
			if(arr[i] >= 70)
				count++;
		}
		
		return count;
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
		
		int count = passCount(arr, n);
		System.out.println(count);

	}

}
