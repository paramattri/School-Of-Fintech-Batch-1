package day7Assignment1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Scanner;

class InvalidDOBException extends Exception{
	public String getMessage() {
		return "Date of Birth cannot be after current date";
	}
}

class AgeCalculator2{
	public int calculateAge(String date) throws ParseException, InvalidDOBException {
		Date d = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		LocalDate bDay = d.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate today = LocalDate.now();
		Period p = Period.between(bDay, today);
		Date todayDate = new Date();
		
		if(d.after(todayDate))
			throw new InvalidDOBException();
		
		return p.getYears();
	}
}

public class TestAgeCalculator2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter DOB");
		String date = sc.nextLine();
		
		AgeCalculator2 a = new AgeCalculator2();
		try {
			int age = a.calculateAge(date);
			System.out.println(age);
		} catch (ParseException e) {
			System.out.println("Date of Birth should be in dd/mm/yyyy format");
		} catch (InvalidDOBException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
