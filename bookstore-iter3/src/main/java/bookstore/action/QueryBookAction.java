package bookstore.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.Book;
import bookstore.service.BookService;

public class QueryBookAction {
	private String title;
	private boolean search;
	private List<Book> books;
	
	private BookService bookService;
	
	public String execute() throws Exception {
		search = false;
		if (title == null || title.equals("")) {
			search = true;
			return "search";
		}
		books = bookService.listRelatedBooks(title);
		if (books.isEmpty())
			return "search";
		return "success";
	}
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}