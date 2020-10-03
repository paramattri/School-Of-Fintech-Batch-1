package dayAssignment3;
import java.util.Scanner;
public class Question6SearchKeys {
	
	static int found[] = new int[20];
	
	public static void searchKeys(int arr[], int size, int value) {
		
		int count = 0;
		boolean founded = false;
		for(int i = 1; i < size; i = i + 2) {
			if(arr[i] == value) {
				founded = true;
				found[count] = arr[i - 1];
				count++;
			}
		}
		if(!founded)
			System.out.println("Key Not Found");
		else {
			for(int key : found) {
				if(key != 0)
					System.out.println(key);
				else
					break;
			}
		}
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
		
		int value = sc.nextInt();
		searchKeys(arr, n, value);

	}

}
