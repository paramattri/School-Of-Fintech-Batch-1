import java.util.Scanner;
public class Assignment1Question4Sequence {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int firstNo = 2;
		int secondNo = 1;
		int thirdNo = 3;
		int nextNo;
		
		System.out.print(firstNo+" "+secondNo+" "+thirdNo+" ");
		while(true) {
			
			nextNo = firstNo + secondNo + thirdNo;
			if(nextNo < n) {
				System.out.print(nextNo+" ");
				firstNo = secondNo;
				secondNo = thirdNo;
				thirdNo = nextNo;
			}else
				break;
		}

	}

}
