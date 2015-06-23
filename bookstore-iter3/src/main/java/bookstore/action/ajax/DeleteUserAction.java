package bookstore.action.ajax;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class DeleteUserAction {
	private String username;
	private String result;
	
	private UserService userService;
	
	public String execute() throws Exception {
		User user = userService.get(username);
		user.setRemoved(true);
		userService.update(user);
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}