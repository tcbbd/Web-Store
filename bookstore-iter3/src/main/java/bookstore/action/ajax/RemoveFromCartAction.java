package bookstore.action.ajax;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class RemoveFromCartAction {
	private String ISBN;
	private String all;
	private String result;
	
	private UserService userService;
	
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user = (User) session.getAttribute("user");
		if (all.equals("true"))
			userService.removeAllBooks(user, ISBN);
		else
			userService.removeOneBook(user, ISBN);
		return "success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getAll() {
		return all;
	}

	public void setAll(String all) {
		this.all = all;
	}
}