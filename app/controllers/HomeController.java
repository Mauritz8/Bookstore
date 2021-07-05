package controllers;

import play.mvc.*;

import models.Book;
import java.util.ArrayList;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render(Book.getBooks()));
    }

	public Result book(int id) {
		return ok(views.html.book.render(Book.getBooks(), id));
	}

	public Result author(String author) {
		ArrayList<Book> booksFromAuthor = Book.getAllBooksFromAuthor(author);
		return ok(views.html.author.render(author, booksFromAuthor));
	}

}
