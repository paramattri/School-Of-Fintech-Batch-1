package day4Assignment2;
import java.util.Scanner;
public class Question6FahrenhietToCentigrade {
	
	public static float convertToCentigrade(int f) {
		
		float c = ((f - 32) / 9) * 5;
		return c;
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int f = sc.nextInt();
		if(f < 0) {
			System.out.println("Invalid Input");
			System.exit(0);
		}
		
		float c = 0f;
		c = convertToCentigrade(f);
		System.out.printf("%.2f",c);
	}

}
