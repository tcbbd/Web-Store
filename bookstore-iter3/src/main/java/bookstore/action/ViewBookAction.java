package bookstore.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.Book;
import bookstore.service.BookService;

public class ViewBookAction {
	private List<Book> books;
	
	private BookService bookService;
	
	public String execute() throws Exception {
		books = bookService.listBooks();
		return "success";
	}
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}