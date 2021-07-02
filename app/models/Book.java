package models;

import java.util.ArrayList;

public class Book {

	String title;
	String author;
	String coverImg;
	int price;

	Book(String title, String author, String coverImg, int price) {
		this.title = title;
		this.author = author;
		this.coverImg = coverImg;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public static ArrayList<Book> getBooks() {

		String[] bookTitles = {"How to program in java play framework", "How to learn java", "Why linux is better than windows"};
		String[] bookAuthors = {"Mauritz", "Mauritz", "Martin"};
		int[] bookPrices = {99, 78, 149};

		ArrayList<Book> books = new ArrayList<Book>(); 

		for (int i=0; i<bookTitles.length; i++) {
			books.add(new Book(bookTitles[i], bookAuthors[i], "assets/images/book-covers-big-2019101610.jpg", bookPrices[i]));
		}

		return books;
	}
}
