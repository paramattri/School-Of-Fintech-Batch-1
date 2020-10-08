package day8Assignment2;

import java.util.Scanner;

class Brackets{
	public void putBrackets(String word) {
		String str = "[";
		str = str.concat(word);
		str = str.concat("]");
		System.out.println(str);
	}
}

class MyThread2 extends Thread{
	
	String word;
	public MyThread2(String word) {
		this.word = word;
	}
	
	public void run() {
		Brackets b = new Brackets();
		b.putBrackets(word);
	}
}

public class PrintWordsWithBracketsThread {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a word: ");
		String word = sc.nextLine();
		
		MyThread2 t1 = new MyThread2(word);
		t1.start();
		
		

	}

}
