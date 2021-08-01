package services;

import models.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class BookService {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
    EntityManager em = emf.createEntityManager();

    public void addBook(Book book) {
        em.getTransaction().begin();
        em.clear();
        em.persist(book);
        em.getTransaction().commit();
    }

    public List<Book> getAllBooks() {
        List<Book> books = em.createQuery("from Book").getResultList();
        return books;
    }

    public List<Book> getBooksFromAuthor(String author) {
        List<Book> booksFromAuthor = em.createQuery("from Book where author=:author")
                .setParameter("author", author)
                .getResultList();
        return booksFromAuthor;
    }

    public Book getBook(int id) {
        Book book = em.createQuery("from Book where id=:id", Book.class)
                .setParameter("id", id)
                .getSingleResult();
        return book;
    }

}
