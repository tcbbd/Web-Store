package bookstore.service;

import java.util.List;

import bookstore.model.Book;

public interface BookService {
	public List<Book> listBooks();
	public List<Book> listRelatedBooks(String title);
	public void save(Book book);
	public Book get(String ISBN);
}