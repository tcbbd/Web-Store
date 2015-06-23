package bookstore.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.CartEntry;
import bookstore.model.User;
import bookstore.service.UserService;

public class ShoppingCartAction {
	private String pay;
	private String errorInfo;
	private String successInfo;
	
	private int total_price;
	
	private UserService userService;
	
	public String execute() throws Exception {
		errorInfo = "";
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		userService.refreshCart(user);
		total_price = 0;
		for (CartEntry entry : user.getCart()) {
			total_price += entry.getNumber() * entry.getBook().getPrice();
		}
		if (pay == null)
			return "this";
		else {
			if (user.getBalance() < total_price) {
				errorInfo = "Óà¶î²»×ã£¬Çë³äÖµ";
				pay = null;
				return "this";
			}
			for (CartEntry entry : user.getCart()) {
				if (entry.getNumber() > entry.getBook().getCurrentNumber()) {
					errorInfo = "¡¶" + entry.getBook().getTitle() + "¡·£¨ISBN£º" + entry.getBook().getISBN() + "£©¿â´æ²»×ã";
					pay = null;
					return "this";
				}
			}
			userService.payForCart(user);
			pay = null;
			return "success";
		}
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
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

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}
}