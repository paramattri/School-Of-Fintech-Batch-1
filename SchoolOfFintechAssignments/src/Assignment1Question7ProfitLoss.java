import java.util.Scanner;
public class Assignment1Question7ProfitLoss {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of dozens of eggs purchased: ");
		int x = sc.nextInt();
		System.out.println("Enter the price per dozen: ");
		int y = sc.nextInt();
		System.out.println("Enter the selling price of 1 egg: ");
		int z = sc.nextInt();
		
		float costPrice = y / 12;
		float gain = z - costPrice;
		float profitPercent = (gain / costPrice) * 100;
		System.out.printf("Harish's profit percentage is %.2f",profitPercent);

	}

}
