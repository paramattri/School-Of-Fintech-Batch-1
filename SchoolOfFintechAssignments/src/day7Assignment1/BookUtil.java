package day7Assignment1;

import java.util.Scanner;

class InvalidInputException1 extends Exception{
	public String getMessage() {
		return "Enter the Correct Input.......";
	}
}

class Book{
	
	public String bookId;
	public String title;
	public String author;
	public String category;
	public float price;
	
	public Book(String bookId, String title, String author, String category, float price) throws InvalidInputException1 {
		super();
		
		if(category.equals("Science") || category.equals("Fiction") || category.equals("Technology") || category.equals("Others")) {
			this.category = category;
		}else
			throw new InvalidInputException1();
			//System.out.println("Enter Valid Category!!");
		if(price < 0)
			throw new InvalidInputException1();
			//System.out.println("Enter Valid Price");
		else
			this.price = price;
		if(bookId.charAt(0) == 'B' && bookId.length() == 4)
			this.bookId = bookId;
		else
			throw new InvalidInputException1();
			//System.out.println("Enter Valid BookId");
		this.title = title;
		this.author = author;
	}	
}

class BookStore{
	
	int counter = 0;
	Book[] books = new Book[10];
	
	public void addBook(Book b) {
		books[counter] = b;
		counter++;
	}
	
	public void searchByTitle(String title) {
		boolean found = false;
		for(int i = 0; i < counter; i++) {
			if(books[i].title.equals(title)) {
				System.out.println("BookId: "+books[i].bookId+"\nTitle: "+books[i].title+"\nAuthor: "+books[i].author+"\nCategory: "+books[i].category+"\nPrice: "+books[i].price);
				found = true;
				break;
			}
		}
		if(!found)
			System.out.println("Book Not Found");
	}
	
	public void searchByAuthor(String author) {
		boolean found = false;
		for(int i = 0; i < counter; i++) {
			if(books[i].author.equals(author)) {
				System.out.println("BookId: "+books[i].bookId+"\nTitle: "+books[i].title+"\nAuthor: "+books[i].author+"\nCategory: "+books[i].category+"\nPrice: "+books[i].price);
				break;
			}
		}
		if(!found)
			System.out.println("Book Not Found");
	}
	
	public void displayAll() {
		for(int i = 0; i < counter; i++) {
			System.out.println("Book"+(i+1)+":");
			System.out.println("BookId: "+books[i].bookId+"\nTitle: "+books[i].title+"\nAuthor: "+books[i].author+"\nCategory: "+books[i].category+"\nPrice: "+books[i].price);
		}
	}
	
	public void displayBook(String bookId) {
		for(int i = 0; i < counter; i++) {
			if(books[i].bookId.equals(bookId)) {
				System.out.println("BookId: "+books[i].bookId+"\nTitle: "+books[i].title+"\nAuthor: "+books[i].author+"\nCategory: "+books[i].category+"\nPrice: "+books[i].price);
				break;
			}
		}
	}
	
	public void updateBook(String bookId) {
		
		int posFind = 0;
		for(int i = 0; i < counter; i++) {
			if(books[i].bookId.equals(bookId))
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
				books[posFind].title = sc.nextLine();
				break;
			case 2:
				System.out.println("Enter The New Author: ");
				sc.nextLine();
				books[posFind].author = sc.nextLine();
				break;
			case 3:
				System.out.println("Enter The New Category: ");
				sc.nextLine();
				books[posFind].category = sc.nextLine();
				break;
			case 4:
				System.out.println("Enter The New Price: ");
				books[posFind].price = sc.nextInt();
				break;
			case 5:
				System.out.println("Exiting, Thanks for Updation!!");
				break;
			default:
				System.out.println("Press Valid Key!");
			}
		}		
	}
	
}

public class BookUtil {

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
				Book b;
				try {
					b = new Book(bookId, title, author, category, price);
					if(!(b.category == null || b.price == 0.0 || b.bookId == null))
						bs.addBook(b);
					else
						System.out.println("NO BOOK ADDED!!");
				} catch (InvalidInputException1 e) {
					System.out.println(e.getMessage());
				}
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
