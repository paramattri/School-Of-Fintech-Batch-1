import java.util.Arrays;
import java.util.Scanner;
public class Assignment1Question10Marks {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number of students: ");
		int noOfStudents = sc.nextInt();
		
		int marks[] = new int[noOfStudents];
		System.out.println("Enter marks scored: ");
		for(int i = 0; i < marks.length; i++) {
			marks[i] = sc.nextInt();
		}
		
		Arrays.sort(marks);
		int sum = 0;
		for(int mark : marks) {
			sum += mark;
		}
		
		int avg = sum / noOfStudents;
		
		System.out.println("Minimum marks: "+marks[0]);
		System.out.println("Maximum marks: "+marks[marks.length - 1]);
		System.out.println("Average marks: "+avg);
	}

}
