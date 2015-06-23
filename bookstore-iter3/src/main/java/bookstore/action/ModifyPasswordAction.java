package bookstore.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;

import bookstore.model.User;
import bookstore.service.UserService;

public class ModifyPasswordAction {
	private String oldPassword;
	private String newPassword;
	private String errorInfo;
	private String successInfo;
	
	private UserService userService;

	public String execute() throws Exception {
		errorInfo = "";
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		if (oldPassword == null || newPassword == null)
			return "this";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(oldPassword.getBytes()))) {
			errorInfo = "‘≠√‹¬Î¥ÌŒÛ£¨«Î÷ÿ ‘";
			oldPassword = newPassword = null;
			return "this";
		}
		user.setPassword(DigestUtils.md5DigestAsHex(newPassword.getBytes()));
		userService.update(user);
		oldPassword = newPassword = null;
		return "success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
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