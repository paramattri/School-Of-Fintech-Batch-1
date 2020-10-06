package day6Assignment1;

import java.util.Scanner;

class Book{
	
	private int bookNo;
	private String title;
	private String author;
	private float price;
	
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	
}

class EngineeringBook extends Book{
	
	private String category;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}

public class BookDetails {

	public static void main(String[] args) {
		
		Book b = new Book();
		Scanner sc = new Scanner(System.in);
		
		//b.setBookNo(sc.nextInt());
		//sc.nextLine();
		//b.setTitle(sc.nextLine());
		//b.setAuthor(sc.nextLine());
		//b.setPrice(sc.nextFloat());
		
		EngineeringBook eb = new EngineeringBook();
		eb.setBookNo(sc.nextInt());
		sc.nextLine();
		eb.setTitle(sc.nextLine());
		eb.setAuthor(sc.nextLine());
		eb.setPrice(sc.nextFloat());
		sc.nextLine();
		eb.setCategory(sc.nextLine());
		
		System.out.println(eb.getBookNo());
		System.out.println(eb.getTitle());
		System.out.println(eb.getAuthor());
		System.out.println(eb.getPrice());
		System.out.println(eb.getCategory());
		

	}

}
