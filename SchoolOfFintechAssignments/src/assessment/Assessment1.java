package assessment;
import java.util.Scanner;
public class Assessment1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int I = sc.nextInt();
		
		int n = (I - A) + 1;
		int arr[] = new int[n];
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = A + count;
			count++;
		}
		
		int result = 0;
	    int c = 1;
	    for(int i = arr.length - 1; i >= 0; i--) {
	        result += arr[i] * c;
	        c *= 10;
	    }
	    
	    System.out.println(result);

	}

}
