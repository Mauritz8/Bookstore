package models;

import java.util.ArrayList;
import java.sql.*;

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

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/Bookstore","mauritz","1234"
				);

			Statement stmt = con.createStatement();
            ResultSet booksTable = stmt.executeQuery("select * from books");
			ArrayList<Book> books = new ArrayList<Book>(); 

            while (booksTable.next()) {
				int id = booksTable.getInt(1);
				String title = booksTable.getString(2);
				String author = booksTable.getString(3);
				String coverImg = booksTable.getString(4);
				double price = booksTable.getDouble(5);

				books.add(new Book(id, title, author, coverImg, price));
            }
			return books;

		} catch(Exception e) {
				System.out.println(e);
		}

		return new ArrayList<Book>();
	}

}
