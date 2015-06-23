package bookstore.action.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.Book;
import bookstore.service.BookService;

public class CheckISBNAction {
	private String ISBN;
	private Map<String, Object> result;
	
	private BookService bookService;
	
	public String execute() throws Exception {
		Book book = bookService.get(ISBN);
		result = new HashMap<String, Object>();
		if (book == null)
			result.put("ok", "");
		else
			result.put("error", "书籍已经存在");
		return "success";
	}
	
	@Autowired
	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}