package assessment;
import java.util.Scanner;
public class Assessment2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int temperatures[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			temperatures[i] = sc.nextInt();
		}
		
		int threshold = sc.nextInt();
		int x = sc.nextInt();
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += temperatures[i];
		}
		
		int avg= sum / n;
		int noOfStudents = 0;
		
		for(int i = avg; i <= threshold; i = i + 2) {
			noOfStudents += x;
		}
		
		if(avg % 2 != 0 && threshold % 2 == 0) {
			noOfStudents = noOfStudents - 1;
		}else if(threshold % 2 != 0 && avg % 2 == 0) {
			noOfStudents = noOfStudents - 1;
		}
			
		System.out.println(noOfStudents);
	}

}
