package day4Assignment2;
import java.util.Scanner;
public class Question5FindCricketerId {
	
	static int cricketer[] = new int[50];
	
	public static void findCricketerId(int array[], int size, int score) {
		
		int count = 0;
		for(int i = 0; i < size; i++) {
			if(i % 2 !=0 ) {
				if(array[i] > score) {
					cricketer[count] = array[i - 1];
					count++;
				}
			}
		}
		
		for(int i = 0; i < cricketer.length; i++) {
			if(cricketer[i] != 0)
				System.out.println(cricketer[i]);
			else
				break;
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
		
		int score = sc.nextInt();
		if(score < 0) {
			System.out.println("Invalid Score");
			System.exit(0);
		}
		
		findCricketerId(arr, n, score);
	}

}
