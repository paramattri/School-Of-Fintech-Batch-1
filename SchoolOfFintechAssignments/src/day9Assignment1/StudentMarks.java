package day9Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;
import java.util.Scanner;

public class StudentMarks {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of Students: ");
		int n = sc.nextInt();
		
		System.out.println("Enter the Marks: ");
		ArrayList<Integer> marks = new ArrayList<Integer>();
		for(int i = 0; i < n; i++) {
			marks.add(sc.nextInt());
		}
		
		ArrayList<Integer> sortedMarks = marks;
		Collections.sort(sortedMarks);
		System.out.println("Highest Marks: "+sortedMarks.get(n - 1));
		
		float avg;
		int sum = 0;
		for(int m: sortedMarks) {
			sum += m;
		}
		
		avg = (float)sum / n;
		System.out.println("Average Marks: "+avg);
		System.out.println("3rd Student Marks: "+marks.get(2));
		
		ListIterator<Integer> iterator = sortedMarks.listIterator();
		System.out.print("Sorted: ");
		while(iterator.hasNext()) {
			System.out.print(iterator.next()+" ");
		}
		

	}

}
