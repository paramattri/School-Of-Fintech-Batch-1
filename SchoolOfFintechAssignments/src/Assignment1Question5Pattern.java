import java.util.Scanner;
public class Assignment1Question5Pattern {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			if(!(i % 3 == 0)) {
				for(int j = 1; j <= i; j++) {
					System.out.print(i+" ");
				}
			}else
				continue;
			System.out.println();
		}

	}

}
