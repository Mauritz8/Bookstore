package models;

import java.util.ArrayList;

public class Book {

	int id;
	String title;
	String author;
	String coverImg;
	double price;

	Book(int id, String title, String author, String coverImg, double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.coverImg = coverImg;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getCoverImg() {
		return coverImg;
	}

	public double getPrice() {
		return price;
	}

	public static ArrayList<Book> getBooks() {

		String[] bookTitles = {"How to program in java play framework", "How to learn java", "Why linux is better than windows", "Why I love java", "Should you learn C#?", "How to program in java play framework", "How to learn java", "Why linux is better than windows", "Why I love java", "Should you learn C#?"};
		String[] bookAuthors = {"Mauritz", "Mauritz", "Martin", "Everyone", "Tobias", "Mauritz", "Mauritz", "Martin", "Everyone", "Tobias"};
		double[] bookPrices = {9.9, 7.8, 14.9, 19.9, 12.9, 9.9, 7.8, 14.9, 19.9, 12.9};

		ArrayList<Book> books = new ArrayList<Book>(); 

		for (int i=0; i<bookTitles.length; i++) {
			books.add(new Book(i, bookTitles[i], bookAuthors[i], "/assets/images/book-cover.jpg", bookPrices[i]));
		}

		return books;
	}
}
