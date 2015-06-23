package bookstore.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class ViewUserAction {
	private List<User> users;
	private int valid_count;
	
	private UserService userService;
	
	public String execute() throws Exception {
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (!user.isAdmin())
			return "index";
		users = userService.listUsers();
		valid_count = 0;
		for (User user2 : users) {
			if (!user2.isRemoved())
				valid_count++;
		}
		return "success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getValid_count() {
		return valid_count;
	}

	public void setValid_count(int valid_count) {
		this.valid_count = valid_count;
	}
}