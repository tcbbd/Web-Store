package bookstore.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class QueryUserAction {
	private String username;
	private boolean search;
	private List<User> users;
	
	private UserService userService;
	
	public String execute() throws Exception {
		search = false;
		if (username == null || username.equals("")) {
			search = true;
			return "search";
		}
		users = userService.listRelatedUsers(username);
		if (users.isEmpty())
			return "search";
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

	public boolean isSearch() {
		return search;
	}

	public void setSearch(boolean search) {
		this.search = search;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}