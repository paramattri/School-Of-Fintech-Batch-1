package day5Assignment1;

class Averager{
	
	public static double avg(int one, int two) {
		
		double average = (double)(one + two) / 2;
		return average;
	}
	
	public static double avg(int one, int two, int three) {
		
		double average = (double)(one + two + three) / 3;
		return average;
	}
	
	public static double avg(double one, double two) {
		
		double average = (one + two) / 2;
		return average;
	}
	
}

public class Question6TestAverage {

	public static void main(String[] args) {
		
		Averager obj = new Averager();
		System.out.println(obj.avg(2, 4));
		System.out.println(obj.avg(2, 4, 6));
		System.out.println(obj.avg(2.4, 4.0));
		
	}

}
