package bookstore.action.ajax;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class CheckUsernameAction {
	private String username;
	private Map<String, Object> result;
	
	private UserService userService;
	
	public String execute() throws Exception {
		User user = userService.get(username);
		result = new HashMap<String, Object>();
		if (user == null)
			result.put("ok", "");
		else
			result.put("error", "用户名已被使用");
		return "success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}
}