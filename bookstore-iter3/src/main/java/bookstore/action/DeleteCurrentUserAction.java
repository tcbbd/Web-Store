package bookstore.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.User;
import bookstore.service.UserService;

public class DeleteCurrentUserAction {
	private String yes;
	private String no;
	private String successInfo;
	
	private UserService userService;
	
	public String execute() throws Exception {
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		if (yes == null && no == null)
			return "warning";
		if (no != null) {
			yes = no = null;
			return "index";
		}
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		user.setRemoved(true);
		userService.update(user);
		yes = no = null;
		return "success";
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String getYes() {
		return yes;
	}

	public void setYes(String yes) {
		this.yes = yes;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getSuccessInfo() {
		return successInfo;
	}

	public void setSuccessInfo(String successInfo) {
		this.successInfo = successInfo;
	}
}