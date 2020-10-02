import java.util.Scanner;
public class Assignment1Question1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the overs bowled: ");
        int overs = sc.nextInt();
        System.out.println("Enter the current run rate: ");
        float runRate = sc.nextFloat();
        System.out.println("Enter the target score: ");
        int target = sc.nextInt();
        
        float requiredRunRate = (target - (runRate * overs)) / (50 - overs);
        System.out.printf("%.2f",requiredRunRate);
		
		

	}

}
