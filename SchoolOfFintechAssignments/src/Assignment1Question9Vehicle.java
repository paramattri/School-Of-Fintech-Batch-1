import java.util.Scanner;
public class Assignment1Question9Vehicle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int sum, temp;
		
		for(int i = m; i <= n; i++) {
			sum = 0;
			temp = i;
			for(int j = 0; j < 4; j++) {
				sum += (temp % 10);
				temp /= 10;
			}
			if(sum == 9) {
				System.out.println(i);
			}
		}

	}

}
