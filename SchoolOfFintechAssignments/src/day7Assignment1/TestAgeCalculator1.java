package day7Assignment1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

class AgeCalculator1{
	public int calculateAge(String date) throws ParseException {
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		LocalDate bDay = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate today = LocalDate.now();
		
		Period p = Period.between(bDay, today);
		return p.getYears();
		
	}
}

public class TestAgeCalculator1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter DOB");
		String date = sc.nextLine();
		
		AgeCalculator1 a = new AgeCalculator1();
		try {
			int age = a.calculateAge(date);
			System.out.println(age);
		} catch (ParseException e) {
			System.out.println("Date of Birth should be in dd/mm/yyyy format");
		}
	}

}
