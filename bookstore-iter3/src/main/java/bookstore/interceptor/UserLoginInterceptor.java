package bookstore.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.UUID;
import bookstore.service.UUIDService;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserLoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5533147468675856783L;
	private UUIDService uuidService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		if (session.getAttribute("isLogin") == null) {
			String uuid = null;
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			if (cookies.length > 0) {
				for (Cookie cookie : cookies) {
					if (cookie.getName().equals("uuid")) {
						uuid = cookie.getValue();
						break;
					}
				}
			}
			if (uuid != null) {
				//cookie uuid=value found
				UUID uuidEntity = uuidService.get(uuid);
				if (uuidEntity == null) {
					session.setAttribute("isLogin", false);
					session.setAttribute("isRemembered", false);
				}
				else {
					session.setAttribute("user", uuidEntity.getUser());
					session.setAttribute("isLogin", true);
					session.setAttribute("isRemembered", true);
					session.setAttribute("uuid", uuid);
				}
			}
			else {
				//cookie uuid=value not found, not remembered
				session.setAttribute("isLogin", false);
				session.setAttribute("isRemembered", false);
			}
		}
		
		String result = invocation.invoke();
		
		return result;
	}

	@Autowired
	public void setUuidService(UUIDService uuidService) {
		this.uuidService = uuidService;
	}
	
}
