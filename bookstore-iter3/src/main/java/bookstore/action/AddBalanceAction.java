package bookstore.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import bookstore.model.User;
import bookstore.service.UserService;

public class AddBalanceAction {
	private String number;
	private String password;
	private String errorInfo;
	private String successInfo;
	
	private UserService userService;
	
	public String execute() throws Exception {
		errorInfo = "";
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		if (number == null || password == null)
			return "this";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			errorInfo = "√‹¬Î¥ÌŒÛ£¨«Î÷ÿ ‘";
			number = password = null;
			return "this";
		}
		int balance = Integer.parseInt(number) + user.getBalance();
		user.setBalance(balance);
		userService.update(user);
		number = password = null;
		return "success";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
