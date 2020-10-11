package casestudy.trainticket;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Ticket{
	private int counter = 100;
	private String pnr;
	private Date travelDate;
	private Train train;
	private TreeMap<Passenger, Integer> passengers = new TreeMap<Passenger, Integer>(Comparator.comparing(Passenger :: getName));
	

	public Ticket(Date travelDate, Train train) {
		this.travelDate = travelDate;
		this.train = train;
	}
	
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public String getPnr() {
		return pnr;
	}
	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	public Date getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}
	public Train getTrain() {
		return train;
	}
	public void setTrain(Train train) {
		this.train = train;
	}
	public TreeMap<Passenger, Integer> getPassengers() {
		return passengers;
	}
	public void setPassengers(TreeMap<Passenger, Integer> passengers) {
		this.passengers = passengers;
	}
	
	private String generatePNR() {
		DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String travelDateString = formatter.format(travelDate);
		pnr = ""+train.getSource().charAt(0)+train.getDestination().charAt(0)+"_"+travelDateString+"_"+counter;
		return pnr;
	}
	
	private double calcPassengerFare(Passenger p) {
		
		double passengerFare;
		if(p.getAge() <= 12)
			passengerFare = train.getTicketPrice() - 0.50 * train.getTicketPrice();
		else if(p.getAge() >= 60)
			passengerFare = train.getTicketPrice() -  0.60 * train.getTicketPrice();
		else if(p.getGender() == 'F')
			passengerFare = train.getTicketPrice() - 0.25 * train.getTicketPrice();
		else
			passengerFare = train.getTicketPrice();
		
		return passengerFare;
	}
	
	public void addPassenger(String name, int age, char gender) {
		Passenger p = new Passenger(name, age, gender);
		int passengerFare = (int)calcPassengerFare(p);
		passengers.put(p, passengerFare);
	}
	
	private double calculateTotalTicketPrice() {
		
		double totalTicketPrice = 0;
		for(Map.Entry<Passenger, Integer> passenger : passengers.entrySet()) {
			totalTicketPrice += passenger.getValue();
		}
		return totalTicketPrice;
	}
	
	private StringBuilder generateTicket() {
		StringBuilder ticket = new StringBuilder();
		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		String travelDateString = formatter.format(travelDate);
		ticket
		.append("PNR").append("\t\t\t").append(":").append("\t"+generatePNR())
		.append("\nTrain No\t:").append("\t"+train.getTrainNo())
		.append("\nTrain Name\t:").append("\t"+train.getTrainName())
		.append("\nFrom \t\t:").append("\t"+train.getSource())
		.append("\nTo \t\t\t:").append("\t"+train.getDestination())
		.append("\nTravel Date\t:").append("\t"+travelDateString)
		.append("\n\nPassengers :")
		.append("\nName\t\t\tAge\t\t\tGender\t\t\tFare\n").toString();
		
		
		for(Map.Entry<Passenger, Integer> passenger : passengers.entrySet()) {
			ticket
			.append(passenger.getKey().getName()+"\t\t\t")
			.append(passenger.getKey().getAge()+"\t\t\t")
			.append(passenger.getKey().getGender()+"\t\t\t")
			.append(passenger.getValue()+"\n")
			.toString();
		}
		
		ticket.append("Total Price : "+calculateTotalTicketPrice()).toString();
		
		return ticket;
	}
	
	public void writeTicket() {
		
		StringBuilder ticket = generateTicket();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(generatePNR()+".txt")));
			bw.write(ticket.toString());
			bw.flush();
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}	
	
}

class Train{
	private int trainNo;
	private String trainName;
	private String source;
	private String destination;
	private double ticketPrice;
	
	public Train(int trainNo, String trainName, String source, String destination, double ticketPrice) {
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
		
}


class Passenger{
	private String name;
	private int age;
	private char gender;
	
	public Passenger(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}
	
}


class TrainDAO{
	
	ArrayList<Train> trainList = new ArrayList<Train>();
	
	public void createTrainList() {
		Train t1 = new Train(1001,"Shatabdi Express","Bangalore","Delhi",2500);
		trainList.add(t1);
		Train t2 = new Train(1002,"Shatabdi Express","Delhi","Bangalore",2500);
		trainList.add(t2);
		Train t3 = new Train(1003,"Udyan Express","Bangalore","Mumbai",1500);
		trainList.add(t3);
		Train t4 = new Train(1004,"Udyan Express","Mumbai","Bangalore",1500);
		trainList.add(t4);
		Train t5 = new Train(1005,"Brindavan Express","Bangalore","Chennai",1000);
		trainList.add(t5);
		Train t6 = new Train(1006,"Brindavan Express","Chennai","Bangalore",1000);
		trainList.add(t6);
	}
	public Train findTrain(int trainNo) {
		
		for(Train t : trainList) {
			if(t.getTrainNo() == trainNo)
				return t;
		}
		return null;
	}
}


public class TicketApplication {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		TrainDAO trainDao = new TrainDAO();
		trainDao.createTrainList();
		
		System.out.println("Enter the Train Number: ");
		int trainNo = sc.nextInt();
		
		Train train = trainDao.findTrain(trainNo);
		if(train == null) {
			System.out.println("Train with given train number does not exist");
			System.exit(0);
		}
		
		sc.nextLine();
		System.out.println("Enter the Travel Date: ");
		String travelDateString = sc.nextLine();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date travelDate = null;
		try {
			travelDate = formatter.parse(travelDateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Date currentDate = new Date();
		if(travelDate.before(currentDate)) {
			System.out.println("Travel Date is before Current Date.");
			System.exit(0);
		}
		
		System.out.println("Enter Number of Passengers: ");
		int noOfPassengers = sc.nextInt();
		
		System.out.println("Enter The Passenger Details: ");
		sc.nextLine();
		
		Ticket ticket = new Ticket(travelDate, train);
		
		for(int i = 0; i < noOfPassengers; i++) {
			System.out.println("Enter Passenger Name: ");
			String name = sc.nextLine();
			System.out.println("Enter Passenger Age: ");
			int age = sc.nextInt();
			System.out.println("Enter Passenger Gender: ");
			sc.nextLine();
			char gender = sc.nextLine().charAt(0);
			ticket.addPassenger(name, age, gender);
		}
		
		ticket.writeTicket();
	}

}
