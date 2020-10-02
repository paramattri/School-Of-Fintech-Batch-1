package day4Assignment2;
import java.util.Scanner;
public class Question1CalculateSalary {
	
	public static int calculateSal(int salary, int shifts) {
		int savings;
		savings = (int)(salary - ((0.20 * salary) + (0.30 * salary)));
		savings = (int)(savings + (0.02 * salary * shifts));
		return savings;
	}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int salary = sc.nextInt();
		int shifts = sc.nextInt();
		int savings = 0;
		
		if(salary > 8000)
			System.out.println("Salary is too large");
		else if(shifts < 0)
			System.out.println("Shifts too small");
		else if(salary < 0)
			System.out.println("Salary too small");
		else {
			savings = calculateSal(salary,shifts);
			System.out.println(savings);
			
			}
		}
}
