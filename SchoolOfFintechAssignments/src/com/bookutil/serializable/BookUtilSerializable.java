package com.bookutil.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class Book implements Serializable{
	
	public String bookId;
	public String title;
	public String author;
	public String category;
	public float price;
	
	public Book(String bookId, String title, String author, String category, float price) {
		super();
		
		if(category.equals("Science") || category.equals("Fiction") || category.equals("Technology") || category.equals("Others")) {
			this.category = category;
		}else
			System.out.println("Enter Valid Category!!");
		if(price < 0)
			System.out.println("Enter Valid Price");
		else
			this.price = price;
		if(bookId.charAt(0) == 'B' && bookId.length() == 4)
			this.bookId = bookId;
		else
			System.out.println("Enter Valid BookId");
		this.title = title;
		this.author = author;
	}	
}


class BookStore{
	
	//int counter = 0;
	ArrayList<Book> books = new ArrayList<Book>();
	//Book[] books = new Book[10];
	
	public void addBook(Book b) {
		
		books.add(b);
		FileOutputStream fos;
		try {
			fos = new FileOutputStream("BookCollection.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(books);
			oos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//books[counter] = b;
		//counter++;
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("BookCollection.ser"));
			ArrayList<Book> b = (ArrayList<Book>) ois.readObject();
			ois.close();
			for(int i = 0; i < b.size(); i++) {
				if(b.get(i).title.equals(title)) {
					System.out.println("BookId: "+b.get(i).bookId+"\nTitle: "+b.get(i).title+"\nAuthor: "+b.get(i).author+"\nCategory: "+b.get(i).category+"\nPrice: "+b.get(i).price);
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Book Not Found");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void searchByAuthor(String author) {
		boolean found = false;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("BookCollection.ser"));
			ArrayList<Book> b = (ArrayList<Book>) ois.readObject();
			ois.close();
			for(int i = 0; i < b.size(); i++) {
				if(b.get(i).author.equals(author)) {
					System.out.println("BookId: "+b.get(i).bookId+"\nTitle: "+b.get(i).title+"\nAuthor: "+b.get(i).author+"\nCategory: "+b.get(i).category+"\nPrice: "+b.get(i).price);
					found = true;
					break;
				}
			}
			if(!found)
				System.out.println("Book Not Found");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayAll() {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("BookCollection.ser"));
			ArrayList<Book> b = (ArrayList<Book>) ois.readObject();
			ois.close();
			for(int i = 0; i < b.size(); i++) {
				System.out.println("Book"+(i+1)+":");
				System.out.println("BookId: "+b.get(i).bookId+"\nTitle: "+b.get(i).title+"\nAuthor: "+b.get(i).author+"\nCategory: "+b.get(i).category+"\nPrice: "+b.get(i).price);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void displayBook(String bookId) {
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("BookCollection.ser"));
			ArrayList<Book> b = (ArrayList<Book>) ois.readObject();
			ois.close();
			for(int i = 0; i < b.size(); i++) {
				if(b.get(i).bookId.equals(bookId)) {
					System.out.println("BookId: "+b.get(i).bookId+"\nTitle: "+b.get(i).title+"\nAuthor: "+b.get(i).author+"\nCategory: "+b.get(i).category+"\nPrice: "+b.get(i).price);
					break;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateBook(String bookId) {
		
		int posFind = 0;
		ObjectInputStream ois;
		try {
			ois = new ObjectInputStream(new FileInputStream("BookCollection.ser"));
			ArrayList<Book> b = (ArrayList<Book>) ois.readObject();
			ois.close();
			for(int i = 0; i < b.size(); i++) {
				if(b.get(i).bookId.equals(bookId))
					posFind = i;
			}
			Scanner sc = new Scanner(System.in);
			int updation = 0;
			while(updation != 5) {
				
				System.out.println("Enter The Updations: ");
				System.out.println("Press: 1: Title Update\t2: Author\t3: Category\t4: Price\t5: Exit");
				updation = sc.nextInt();
				switch(updation) {
				case 1:
					System.out.println("Enter The New Title: ");
					sc.nextLine();
					b.get(posFind).title = sc.nextLine();
					break;
				case 2:
					System.out.println("Enter The New Author: ");
					sc.nextLine();
					b.get(posFind).author = sc.nextLine();
					break;
				case 3:
					System.out.println("Enter The New Category: ");
					sc.nextLine();
					b.get(posFind).category = sc.nextLine();
					break;
				case 4:
					System.out.println("Enter The New Price: ");
					b.get(posFind).price = sc.nextInt();
					break;
				case 5:
					System.out.println("Exiting, Thanks for Updation!!");
					break;
				default:
					System.out.println("Press Valid Key!");
				}
			}		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class BookUtilSerializable {

	public static void main(String[] args) {
		
		BookStore bs = new BookStore();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Enter the Number for Operation: ");
			System.out.println("Press: 1: Add Book\t2: Search By Title\t3: Search By Author\t4: Display All\t5: Display Book\t6: Update Book\t7: Exit");
			int operation = sc.nextInt();
			sc.nextLine();
			switch(operation) {
			case 1:
				System.out.println("Enter BookId: ");
				String bookId = sc.nextLine();
				System.out.println("Enter Title: ");
				String title = sc.nextLine();
				System.out.println("Enter Author: ");
				String author = sc.nextLine();
				System.out.println("Enter Category: ");
				String category = sc.nextLine();
				System.out.println("Enter Price: ");
				float price = sc.nextFloat();
				Book b = new Book(bookId, title, author, category, price);
				if(!(b.category == null || b.price == 0.0 || b.bookId == null))
					bs.addBook(b);
				else
					System.out.println("NO BOOK ADDED!!");
				break;
			case 2:
				System.out.println("Enter The TITLE To be Searched: ");
				String titleSearch = sc.nextLine();
				bs.searchByTitle(titleSearch);
				break;
			case 3:
				System.out.println("Enter The AUTHOR To be Searched: ");
				String authorSearch = sc.nextLine();
				bs.searchByAuthor(authorSearch);
				break;
			case 4:
				bs.displayAll();
				break;
			case 5:
				System.out.println("Enter The BOOKID To be Searched: ");
				String bookIdSearch = sc.nextLine();
				bs.displayBook(bookIdSearch);
				break;
			case 6:
				System.out.println("Enter The BOOKID To be Updated: ");
				String bookIdUpdate = sc.nextLine();
				bs.updateBook(bookIdUpdate);
				break;
			case 7:
				System.out.println("Exiting..");
				System.exit(0);
			default:
				System.out.println("Enter the Valid Operation: ");
			}
		}	

	}

}
