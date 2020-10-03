package day4Assignment3;
import java.util.Scanner;
public class Question8MultiplesAverage {
	
	public static float findAverageBy5s(int n) {
		
		int sum = 0;
		int count = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i % 5 == 0) {
				sum += i;
				count++;
			}
		}
		
		float avg = (float)sum / count;
		return avg;
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		if(n < 0 || n > 32767) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		float avg = findAverageBy5s(n);
		System.out.printf("%.2f",avg);

	}

}
