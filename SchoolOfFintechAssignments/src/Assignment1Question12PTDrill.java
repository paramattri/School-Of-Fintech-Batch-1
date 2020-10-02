import java.util.Arrays;
import java.util.Scanner;
public class Assignment1Question12PTDrill {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of students: ");
		int noOfStudents = sc.nextInt();
		
		String names[] = new String[noOfStudents];
		System.out.println("Enter Names: ");
		sc.nextLine();
		for(int i = 0; i < names.length; i++) {
			names[i] = sc.nextLine();
		}
		
		Arrays.sort(names);
		int row = (int)Math.sqrt(noOfStudents);
		int col = row;
		int mid = (row - 1) / 2;
		String names2D [][] = new String[row][col];
		
		int count = 0;
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				names2D[i][j] = names[count];
				count++;
			}
		}
		
		System.out.print("Middle Row: ");
		for(int i = 0; i < col; i++) {
			System.out.print(names2D[mid][i]+" ");
		}
		System.out.print("\nMiddle Column: ");
		for(int i = 0; i < row; i++) {
			System.out.print(names2D[i][mid]+" ");
		}
	}
}
