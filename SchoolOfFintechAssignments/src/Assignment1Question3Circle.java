import java.util.Scanner;
public class Assignment1Question3Circle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the Radius: ");
		double radius = sc.nextDouble();
		System.out.println("Enter Output Required: ");
		sc.nextLine();
		String code = sc.nextLine();
		double output; 
		
		switch(code) {
		case "DIA":
			output = 2 * radius;
			System.out.printf("Diameter of Circle is: %.2f",output);
			break;
		case "AR":
			output = Math.PI * radius * radius;
			System.out.printf("Area of Circle is: %.2f",output);
			break;
		case "PER":
			output = 2* Math.PI * radius;
			System.out.printf("Perimeter of Circle is: %.2f",output);
			break;
		case "ARSEM":
			output = Math.PI * radius;
			System.out.printf("Area of Semi Circle is: %.2f",output);
			break;
		default:
			System.out.println("Enter Valid Code");
		}

	}

}
