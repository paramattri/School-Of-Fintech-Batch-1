import java.util.Scanner;
public class Assignment1Question2Bill {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the previous reading: ");
		int previousReading = sc.nextInt();
		System.out.println("Enter the current reading: ");
		int currentReading = sc.nextInt();
		
		int unitsConsumed = currentReading - previousReading;
		double billTotal;
		int temp;
		
		if(unitsConsumed >= 0 && unitsConsumed <= 30) {
			billTotal = unitsConsumed * 2.3;
		}else if(unitsConsumed > 30 && unitsConsumed <= 100){
			billTotal = (30 * 2.3) + (unitsConsumed - 30) * 3.5;
		}else {
			billTotal = (30 * 2.3) + (70 * 3.5) + (unitsConsumed - 100) * 4.6;
		}
		
		System.out.printf("Bill Amount is: %.2f",billTotal);
	}

}
