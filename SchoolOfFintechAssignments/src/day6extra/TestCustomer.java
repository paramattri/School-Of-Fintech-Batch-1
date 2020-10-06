package day6extra;

//import day6Assignment1.question4.Address;

class Address{
	private String addressLine;
	private String city;
	
	public Address(String addressLine, String city) {
		super();
		this.addressLine = addressLine;
		this.city = city;
	}
	
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}	
	
	public String getAddressDetails() {
		return addressLine+", "+city;
	}
}

class Customer{
	
	private String customerName;
	private Address residentialAddress;
	private Address officialAddress;
	
	public Customer() {
		
	}
	public Customer(String customerName, Address residentialAddress) {
		super();
		this.customerName = customerName;
		this.residentialAddress = residentialAddress;
	}
	
	public Customer(String customerName, Address residentialAddress, Address officialAddress) {
		super();
		this.customerName = customerName;
		this.residentialAddress = residentialAddress;
		this.officialAddress = officialAddress;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Address getResidentialAddress() {
		return residentialAddress;
	}
	public void setResidentialAddress(Address residentialAddress) {
		this.residentialAddress = residentialAddress;
	}
	
	public Address getOfficialAddress() {
		return officialAddress;
	}
	public void setOfficialAddress(Address officialAddress) {
		this.officialAddress = officialAddress;
	}
	
	public String getCustomerDetails() {
		
		return "Customer: "+customerName+"\nResidential Address: "+residentialAddress.getAddressDetails()+"\nOfficial Address: "+officialAddress.getAddressDetails();
	}
	
}

public class TestCustomer {

	public static void main(String[] args) {
		
		// Can use getters and setters also.
		Address a = new Address("1st Main HSR Layout","Bangalore");
		Address a1 = new Address("1st Main Electronics City","Bangalore");
		Customer c = new Customer("John", a, a1);
		System.out.println(c.getCustomerDetails());

	}

}
