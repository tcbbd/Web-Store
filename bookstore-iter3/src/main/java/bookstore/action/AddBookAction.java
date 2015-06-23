package bookstore.action;

import java.text.SimpleDateFormat;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.Book;
import bookstore.model.User;
import bookstore.service.BookService;

public class AddBookAction {
	private String ISBN;
	private String title;
	private String author;
	private String publish_date;
	private String category;
	private int price;
	private int number;
	private String errorInfo;
	private String successInfo;
	
	private BookService bookService;
	
	public String execute() throws Exception {
		//TODO 检查日期是否有效(e.g. 2000-30-40 -> 无效)
		errorInfo = "";
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (!user.isAdmin())
			return "index";
		if (ISBN == null || title == null || author == null || publish_date == null || category == null)
			return "this";
		Book book = new Book();
		book.setISBN(ISBN);
		book.setTitle(title);
		book.setAuthor(author);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		book.setPublishDate(sdf.parse(publish_date));
		book.setCategory(category);
		book.setPrice(price);
		book.setCurrentNumber(number);
		bookService.save(book);
		ISBN = title = author = publish_date = category = null;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(String successInfo) {
		this.successInfo = successInfo;
	}
}