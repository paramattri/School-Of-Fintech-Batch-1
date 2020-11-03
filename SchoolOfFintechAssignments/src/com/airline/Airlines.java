package com.airline;

public abstract class Airlines {
	
	private String airId;
	private String source;
	private String destination;
	
	public Airlines(String airId, String source, String destination) throws InvalidEntryException {
		this.airId = airId;
		this.source = source;
		this.destination = destination;
		
		if(!(airId.substring(0, 6).equals("BOEING"))) {
			System.out.println("airId should begin with BOEING");
			throw new InvalidEntryException();
		}
		if(source.equals(destination)) {
			System.out.println("Source and destination cannot be same");
			throw new InvalidEntryException();
		}
		
	}
	
	public abstract void bookTicket(int noOfTickets);
		
}
