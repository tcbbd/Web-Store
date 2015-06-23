package bookstore.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.BookDao;
import bookstore.model.Book;
import bookstore.service.BookService;

public class BookServiceImpl implements BookService {
	private BookDao bookDao;
	
	@Transactional
	public List<Book> listBooks() {
		return bookDao.listBooks();
	}
	
	@Transactional
	public List<Book> listRelatedBooks(String title) {
		return bookDao.listRelatedBooks(title);
	}
	
	@Transactional
	public void save(Book book) {
		bookDao.save(book);
	}
	
	@Transactional
	public Book get(String ISBN) {
		return bookDao.get(ISBN);
	}
	
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
}