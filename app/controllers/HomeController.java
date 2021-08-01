package controllers;

import models.Book;
import services.BookService;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.List;

public class HomeController extends Controller {

	@Inject
	BookService bookService;

	public Result index() {
		List<Book> books = bookService.getAllBooks();
		return ok(views.html.index.render(books));
	}

	public Result book(int id) {
		Book book = bookService.getBook(id);
		return ok(views.html.book.render(book));
	}

	public Result author(String author) {
		List<Book> booksFromAuthor = bookService.getBooksFromAuthor(author);
		return ok(views.html.author.render(author, booksFromAuthor));
	}

}
