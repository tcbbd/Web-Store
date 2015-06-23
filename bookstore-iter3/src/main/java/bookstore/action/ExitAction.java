package bookstore.action;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.service.UUIDService;

public class ExitAction {
	private UUIDService uuidService;
	
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object isRemembered = session.getAttribute("isRemembered");
		if (isRemembered != null && ((Boolean) isRemembered)) {
			uuidService.delete((String) session.getAttribute("uuid"));
			session.setAttribute("isRemembered", false);
			Cookie cookie = new Cookie("uuid", "");
			cookie.setMaxAge(0);
			ServletActionContext.getResponse().addCookie(cookie);
		}
		session.setAttribute("isLogin", false);
		return "success";
	}
	
	@Autowired
	public void setUuidService(UUIDService uuidService) {
		this.uuidService = uuidService;
	}
}
