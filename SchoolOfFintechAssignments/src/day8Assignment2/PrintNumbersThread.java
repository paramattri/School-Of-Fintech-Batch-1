package day8Assignment2;

class MyThread extends Thread{
	
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class PrintNumbersThread {

	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		t1.start();

	}

}
