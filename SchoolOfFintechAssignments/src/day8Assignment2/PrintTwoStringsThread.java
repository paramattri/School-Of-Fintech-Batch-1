package day8Assignment2;

class MyThread1 extends Thread{
	
	private String msg;
	
	public MyThread1(String msg) {
		this.msg = msg;
	}
	
	public void run() {
		if(msg.equals("thread1"))
			System.out.println("Hi! I am thread");
		else
			System.out.println("Mee too");
	}
}

public class PrintTwoStringsThread {

	public static void main(String[] args) {
		
		MyThread1 t1 = new MyThread1("thread1");
		MyThread1 t2 = new MyThread1("thread2");
		t1.start();
		t2.start();
	}

}
