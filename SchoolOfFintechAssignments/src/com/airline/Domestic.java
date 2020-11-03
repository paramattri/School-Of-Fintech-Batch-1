package com.airline;

public class Domestic extends Airlines{
	
	String zonalCode;
	double ticketCost;
	
	public Domestic(String airId, String source, String destination, String zonalCode) throws InvalidEntryException {
		super(airId, source, destination);
		this.zonalCode = zonalCode;
	}
	

	@Override
	public void bookTicket(int noOfTickets) {
		
		double totalCost;
		if(zonalCode.equals("Z001")) {
			ticketCost = 3500;
		}
		else if(zonalCode.equals("Z002")) {
			ticketCost = 4000;
		}
		else if(zonalCode.equals("Z003")) {
			ticketCost = 4500;
		}
		
		totalCost = noOfTickets * ticketCost;
		System.out.println("Total Cost: "+totalCost);
	}
	
}
