package day8Assignment2;

class Table{
	public synchronized void printTable(int num) {
		for(int i = 1; i <= 10; i++) {
			System.out.println(num * i);
		}
	}
}

class Mythread3 extends Thread{
	Table table;
	int num;
	
	public Mythread3(Table table, int num) {
		this.table = table;
		this.num = num;
	}
	
	public void run() {
		table.printTable(num);
	}
}

public class TablesThread {

	public static void main(String[] args) {
		
		Table table = new Table();
		Mythread3 t1 = new Mythread3(table, 5);
		Mythread3 t2 = new Mythread3(table, 100);
		t1.start();
		t2.start();
	}

}
