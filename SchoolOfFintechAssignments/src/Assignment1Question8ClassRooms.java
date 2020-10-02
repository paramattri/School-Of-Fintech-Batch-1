import java.util.Scanner;
public class Assignment1Question8ClassRooms {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int capacity[] = new int[3];
		
		for(int i = 1; i <= capacity.length; i++) {
			System.out.println("Enter C"+i+" Capacity");
			capacity[i-1] = sc.nextInt();
		}
		
		System.out.println("Enter no of Students: ");
		int noOfStudents = sc.nextInt();
		int count = 0;
		
		for(int number : capacity) {
			if(noOfStudents <= number)
				count++;
		}
		if(count > 0) {
			System.out.println(count+" lab(s) can accommodate "+noOfStudents+" students");
		}else
			System.out.println("None of the labs can accommodate "+noOfStudents+" students");	
	}

}
