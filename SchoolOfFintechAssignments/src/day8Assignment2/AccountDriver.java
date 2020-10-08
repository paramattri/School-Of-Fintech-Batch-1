package day8Assignment2;

class Account{
	private int acctno;
	private String name;
	private double balance;
	
	public Account(int acctno, String name, double balance) {
		this.acctno = acctno;
		this.name = name;
		this.balance = balance;
	}
	
	public synchronized void withdraw(double amount) {
		balance = balance - amount;
		System.out.println(balance);
	}
}

class Thread4 extends Thread{
	
	Account account;
	double amount;
	
	public Thread4(Account account,double amount) {
		this.account = account;
		this.amount = amount;
	}
	
	public void run() {
		account.withdraw(amount);
	}
	
}

public class AccountDriver {

	public static void main(String[] args) {
		
		Account ac = new Account(1234, "Param", 20000);
		Thread4 t1 = new Thread4(ac, 5000);
		Thread4 t2 = new Thread4(ac, 10000);
		t1.start();
		t2.start();

	}

}
