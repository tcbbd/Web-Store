package bookstore.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.service.LoginService;

public class LoginAction {
	private String username;
	private String password;
	private String errorInfo;
	private String successInfo;
	private boolean remember_me;
	
	private LoginService loginService;

	public String execute() throws Exception {
		errorInfo = "";
		if ((Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		if (username == null || password == null)
			return "this";
		if (loginService.login(username, password, remember_me)) {
			ServletActionContext.getRequest().getSession().setAttribute("isLogin", true);
			username = password = null;
			return "success";
		}
		else {
			errorInfo = loginService.getErrorInfo();
			username = password = null;
			return "this";
		}
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

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public boolean isRemember_me() {
		return remember_me;
	}

	public void setRemember_me(boolean remember_me) {
		this.remember_me = remember_me;
	}

	public String getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(String successInfo) {
		this.successInfo = successInfo;
	}
}
