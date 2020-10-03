package day4Assignment2;
import java.util.Scanner;
public class Question7HighestFeedback {
	
	static int feedback[];
	
	public static void highestFeedback(int metLife[], int hardFort[], int size) {
		
		feedback = new int[size * 2];
		boolean found;
		int count = 0;
		
		for(int i = 0; i < size; i = i + 2) {
			found = false;
			for(int j = 0; j < size; j = j + 2) {
				if(metLife[i] == hardFort[j]) {
					found = true;
					feedback[count] = metLife[i];
					feedback[count + 1] = Math.max(metLife[i + 1], hardFort[j + 1]);
					count = count + 2;
				}
			}
			if(found == false) {
				feedback[count] = metLife[i];
				feedback[count + 1] = metLife[i + 1];
				count = count + 2;
			}
		}
		
		for(int i = 0; i < size; i = i + 2) {
			found = false;
			for(int j = 0; j < size; j = j + 2) {
				if(hardFort[i] == feedback[j])
					found = true;
			}
			if(found == false) {
				feedback[count] = hardFort[i];
				feedback[count + 1] = hardFort[i + 1];
				count = count + 2;
			}
		}
		
		for(int i = 0; i < size * 2; i = i + 2) {
			if(feedback[i] != 0) {
				System.out.println(feedback[i]);
				System.out.println(feedback[i + 1]);
			}else
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
		
		int metLife[] = new int[n];
		int hardFort[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			metLife[i] = sc.nextInt();
			if(metLife[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
		}
		
		for(int i = 0; i < n; i++) {
			hardFort[i] = sc.nextInt();
			if(hardFort[i] < 0) {
				System.out.println("Invalid Input");
				System.exit(0);
			}
			
		}
		
		highestFeedback(metLife,hardFort,n);

	}

}
