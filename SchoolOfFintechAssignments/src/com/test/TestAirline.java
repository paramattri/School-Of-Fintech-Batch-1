package com.test;

import java.util.ArrayList;

import com.airline.*;
public class TestAirline {

	public static void main(String[] args) {
		
		ArrayList<Airlines> airlines = new ArrayList<>();
		try {
			Domestic d1 = new Domestic("BOEING001", "Delhi", "Bangalore", "Z003");
			Domestic d2 = new Domestic("BOEING002", "Delhi", "Mumbai", "Z002");
			
			International i1 = new International("BOEING003", "Delhi", "USA", "I003");
			International i2 = new International("BOEING004", "Delhi", "UK", "I002");
			
			airlines.add(d1);
			airlines.add(d2);
			airlines.add(i1);
			airlines.add(i2);
			
			for(Airlines airline : airlines) {
				airline.bookTicket(4);
			}
			
		} catch (InvalidEntryException e) {
			System.out.println("Enter the Correct Details...");
			//e.printStackTrace();
		}
		
		
	}

}
