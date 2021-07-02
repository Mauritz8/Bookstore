package models;

import java.util.ArrayList;

public class Book {

	String title;
	String author;

	Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public static ArrayList<Book> getBooks() {

		String[] bookTitles = {"How to program in java play framework", "How to learn java", "Why linux is better than windows"};
		String[] bookAuthors = {"Mauritz", "Mauritz", "Martin"};

		ArrayList<Book> books = new ArrayList<Book>(); 

		for (int i=0; i<bookTitles.length; i++) {
			books.add(new Book(bookTitles[i], bookAuthors[i]));
		}

		return books;
	}
}
