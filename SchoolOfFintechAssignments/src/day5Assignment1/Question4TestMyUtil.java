package day5Assignment1;

class MyUtil{
	
	public static double throwDice() {
		double randomNumber;
		randomNumber = (Math.random() * (6 - 1)) + 1; 
		return randomNumber;
	}
	
	public static float average(int arr[]) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		float avg = (float)sum / arr.length;
		return avg;
	}
	
}

public class Question4TestMyUtil {

	public static void main(String[] args) {
		
		MyUtil myu = new MyUtil();
		System.out.println(myu.throwDice());
		
		int arr1[] = {1,2,3,4,5};
		int arr2[] = {6,7,8,9,10};
		
		System.out.println(myu.average(arr1));
		System.out.println(myu.average(arr2));
		System.out.println(Math.max(10, 3));
		System.out.println(Math.min(4, 11));
		
		double randNumber = myu.throwDice();
		System.out.println(Math.ceil(randNumber));
		System.out.println(Math.floor(randNumber));
		System.out.println(Math.round(randNumber));

	}

}
