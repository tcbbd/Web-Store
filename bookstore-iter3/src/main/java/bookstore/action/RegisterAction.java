package bookstore.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import bookstore.model.User;
import bookstore.service.UserService;

public class RegisterAction {
	private String username;
	private String password;
	private String email;
	private String phone;
	private String gender;
	private String errorInfo;
	private String successInfo;
	
	private UserService userService;
	
	public String execute() throws Exception {
		errorInfo = "";
		if ((Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		if (username == null || password == null || email == null || phone == null || gender == null)
			return "this";
		User user = new User();
		user.setUsername(username);
		user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
		user.setEmail(email);
		user.setPhone(phone);
		if (gender.equals("male"))
			user.setMale(true);
		else
			user.setMale(false);
		user.setAdmin(false);
		user.setRemoved(false);
		user.setBalance(0);
		userService.save(user);
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		session.setAttribute("isLogin", true);
		session.setAttribute("isRemembered", false);
		username = password = email = phone = gender = null;
		return "success";
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
