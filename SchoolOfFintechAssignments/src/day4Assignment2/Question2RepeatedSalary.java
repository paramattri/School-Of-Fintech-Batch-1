package day4Assignment2;
import java.util.Scanner;
public class Question2RepeatedSalary {
	
	public static int countRepeaters(int salaries[],int n) {
		int repeatCount = 0;
		
		for(int i = 0; i < n; i++) {
			int salary = salaries[i];
			repeatCount = 0;
			for(int j = 0; j < n; j++) {
				if(salary == salaries[j]) {
					repeatCount++;
				}
			}
			if(repeatCount > 1)
				break;
		}
		return repeatCount;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		int salaries[] = new int[n]; 
		int repeatCount = 0;
		
		for(int i = 0; i < n; i++) {
			salaries[i] = sc.nextInt();
			if(salaries[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		
		repeatCount = countRepeaters(salaries,n);
		System.out.println(repeatCount);
	}

}
