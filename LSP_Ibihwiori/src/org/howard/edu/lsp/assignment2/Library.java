package org.howard.edu.lsp.assignment2;
import java.util.ArrayList;

public class Library {
	private String address;
	private String hours;
	public  ArrayList<Book> booksAvailable = new ArrayList<Book>();
	
	public static Book currentBook;
	
	private void addBook(Book book) {
 
		booksAvailable.add(book);
	}

	private void returnBook(String string) {
	 
		for(int i = 0; i < booksAvailable.size(); i++) {
			if(booksAvailable.get(i).getTitle()==string && booksAvailable.get(i).isBorrowed() ) {
				booksAvailable.get(i).returned();
				System.out.println("You successfully returned "+ string);
			}
		}
		
	}

	private  void printAvailableBooks() {
		int tmp = 0;
		if(booksAvailable.isEmpty()) {
			System.out.println("No book in catalog");

		}
		else {
		for(int i = 0; i < booksAvailable.size(); i++) {
			if(!booksAvailable.get(i).isBorrowed()) {
			System.out.println(booksAvailable.get(i).getTitle());
			}
			else {
				System.out.println("   ");

			}
		}
		}
		
	}

	private void borrowBook(String string) {
		
		int temp=100;
		for(int i = 0; i < booksAvailable.size();i++) {
			if(booksAvailable.get(i).getTitle()==string) {
				temp = i;
				
				
				
			}
			
		
			
			
		}
		if(temp<100 && booksAvailable.get(temp).isBorrowed()) {
			System.out.println("Sorry, this book is already borrowed.");
		}
		
		else if(temp < 100 &&!booksAvailable.get(temp).isBorrowed()){
		booksAvailable.get(temp).borrowed();
		System.out.println("You have successfully borrowed "+string+".");

		temp=1;
		}
		else {
			System.out.println("Sorry, this book is not in our catalog.");

		}
		
		
		
		
	}
	private  void printAddress() {
		System.out.println(address);
	}

	private void printOpeningHours() {
		System.out.println("Libraries are open daily from "+hours);

		
	}

	
	public Library(String title) {
	// Implement the constructor
		
		address = title;
		hours = "9pm to 5pm.";
		
	}
	
	public static void main(String[] args) {
	// Create two libraries
	Library firstLibrary = new Library("10 Main St.");
	Library secondLibrary = new Library("228 Liberty St.");
	
	
	// Add four books to the first library
	firstLibrary.addBook(new Book("The Da Vinci Code"));
	firstLibrary.addBook(new Book("Le Petit Prince"));
	firstLibrary.addBook(new Book("A Tale of Two Cities"));
	firstLibrary.addBook(new Book("The Lord of the Rings"));
	// Print opening hours and the addresses
	System.out.println("Library hours:");
	firstLibrary.printOpeningHours();

	System.out.println();
	System.out.println("Library addresses:");
	firstLibrary.printAddress();
	secondLibrary.printAddress();
	System.out.println(); 

	//secondLibrary.printAvailableBooks();

	System.out.println();
	// Try to borrow The Lords of the Rings from both libraries
	System.out.println("Borrowing The Lord of the Rings:");
	firstLibrary.borrowBook("The Lord of the Rings");
	firstLibrary.borrowBook("The Lord of the Rings");
	secondLibrary.borrowBook("The Lord of the Rings");
	System.out.println();
	// Print the titles of all available books from both libraries
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
	System.out.println();
	System.out.println("Books available in the second library:");
	secondLibrary.printAvailableBooks();
	System.out.println();
	// Return The Lords of the Rings to the first library
	System.out.println("Returning The Lord of the Rings:");
	firstLibrary.returnBook("The Lord of the Rings");
	System.out.println();
	System.out.println("Books available in the first library:");
	firstLibrary.printAvailableBooks();
	 }


	}
