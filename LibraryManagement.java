package ExceptionCollections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author;
    }
}

class BookNotException extends Exception {
    public BookNotException(String message) {
        super(message);
    }
}

public class LibraryManagement {
    private HashMap<Integer, Book> books = new HashMap<>();
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    public void addBook(Book book) {
        books.put(book.id, book);
        System.out.println("Book added: " + book);
    }
    
    public void removebook(int id) throws BookNotException{
    	if(!books.containsKey(id)) {
    		throw new BookNotException("book not found : " + id);
    	}
    	
    	books.remove(id);
    	System.out.println("book removed !!");
    }
    
    public Book searchbook(int id) throws BookNotException{
    	
    	if(books.containsKey(id)) {
    		throw new BookNotException("book not found !!!" + id);
    	}
    	return books.get(id);
    	
    }
    
    public void borrowbook(int id) throws BookNotException{
    	Book book = searchbook(id);
    	borrowedBooks.add(book);
    	books.remove(id);
    	System.out.println("Borrowed Books : " + id);
    	
    }
    
    public void returnbook(Book book) throws BookNotException{
    	books.put(book.id, book);
    	borrowedBooks.remove(book);
    	System.out.println("Returned : " + book);
    }
    
    public void displayallbooks() {
    	if(books.isEmpty()) {
    		System.out.println("there is no books !!!");
    	}else {
    		System.out.println("available books !!!");
    		for(Book book : books.values()) {
    			System.out.println(book);
    		}
    	}
    }
    
    public static void main(String[]args) {
    	LibraryManagement library = new LibraryManagement();
    	Scanner sc = new Scanner(System.in);
    	boolean exit = false;
    	
    	while(!exit) {
    		System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Search Book");
            System.out.println("4. Borrow Book");
            System.out.println("5. Return Book");
            System.out.println("6. Display Books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            
            try {
            	int choice = Integer.parseInt(sc.nextLine());
            	
            	switch(choice) {
            	case 1:
            		System.out.println("Enter the book id");
            		int id = Integer.parseInt(sc.nextLine());
            		System.out.println("Enter the Book Title");
            		String title = sc.nextLine();
            		System.out.println("Enter the author");
            		String author = sc.nextLine();
            		library.addBook(new Book(id,title,author));
            		break;
            	case 2:
            		System.out.println("enter the id to remove book!");
            		int bid = Integer.parseInt(sc.nextLine());
            		library.removebook(bid);
            		break;
            	case 3:
            		System.out.println("search for the boook !!");
            		int searchid = Integer.parseInt(sc.nextLine());
            		library.searchbook(searchid);
            		break;
            	case 4:
            		System.out.println("Borrow a Book!!");
            		library.borrowbook(Integer.parseInt(sc.nextLine()));
            		break;
            	case 5:
            		System.out.println("Return the book!!");
            		System.out.println("Enter the book id");
            		int retid = Integer.parseInt(sc.nextLine());
            		System.out.println("Enter the Book Title");
            		String rettitle = sc.nextLine();
            		System.out.println("Enter the author");
            		String retauthor = sc.nextLine();
            		library.addBook(new Book(retid,rettitle,retauthor));
            		break;    
            	case 6:
            		library.displayallbooks();
            		break;
            	case 7:
            		System.out.println("Exiting------Thank you");
            		exit = true;
            		break;
            	default:
            		System.out.println("enter the valid choice!!!!!");
            	}
            		
            	}catch(BookNotException e) {
            		System.out.println("Error : " + e.getMessage());
            	}catch(NumberFormatException e) {
            		System.out.println("Format of the number is  invalid " + e.getMessage());
            	}
            }
            sc.close();
    	}
    	
    }

