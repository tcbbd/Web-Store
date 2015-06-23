package bookstore.dao;

import java.util.List;

import bookstore.model.Book;

public interface BookDao extends CommonDao<Book> {
	public List<Book> listBooks();
	public List<Book> listRelatedBooks(String title);
}