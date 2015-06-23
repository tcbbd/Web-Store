package bookstore.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class ModifyUserinfoAction {
	private String email;
	private String phone;
	private String gender;
	private String errorInfo;
	private String successInfo;
	
	private UserService userService;

	public String execute() throws Exception {
		errorInfo = "";
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		if (email == null || phone == null || gender == null)
			return "this";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		user.setEmail(email);
		user.setPhone(phone);
		if (gender.equals("male"))
			user.setMale(true);
		else
			user.setMale(false);
		userService.update(user);
		email = phone = gender = null;
		return "success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
