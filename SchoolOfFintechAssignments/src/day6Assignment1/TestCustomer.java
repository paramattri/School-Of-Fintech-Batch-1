package day6Assignment1;

class Address{
	private String addressLine;
	private String city;
	
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
	
	public Customer() {
		
	}
	public Customer(String customerName, Address residentialAddress) {
		super();
		this.customerName = customerName;
		this.residentialAddress = residentialAddress;
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
	
	public String getCustomerDetails() {
		
		return "Customer: "+customerName+"\nResidential Address: "+residentialAddress.getAddressDetails();
	}
	
}

public class TestCustomer {

	public static void main(String[] args) {
		
		Customer c = new Customer();
		Address a = new Address();
		a.setAddressLine("1st Main HSR Layout");
		a.setCity("Bangalore");
		c.setCustomerName("John");
		c.setResidentialAddress(a);
		//System.out.println(a.getAddressDetails());
		System.out.println(c.getCustomerDetails());
		//System.out.println(c.getCustomerName());
		//System.out.println(c.getResidentialAddress());
		
		Customer c1 = new Customer("Johnny",a);
		System.out.println(c1.getCustomerDetails());

	}

}
