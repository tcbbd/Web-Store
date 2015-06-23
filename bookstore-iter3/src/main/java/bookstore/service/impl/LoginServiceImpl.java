package bookstore.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import bookstore.dao.UUIDDao;
import bookstore.dao.UserDao;
import bookstore.model.UUID;
import bookstore.model.User;
import bookstore.service.LoginService;

public class LoginServiceImpl implements LoginService {
	private UserDao userDao;
	private UUIDDao uuidDao;
	private String errorInfo;
	
	@Transactional
	public boolean login(String username, String password, boolean remembered) {
		User user = userDao.get(username);
		if (user == null) {
			errorInfo = "用户名不存在，请重试";
			return false;
		}
		if (!user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
			errorInfo = "密码不正确，请重试";
			return false;
		}
		if (user.isRemoved()) {
			errorInfo = "用户已被删除，请重试";
			return false;
		}
        HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("user", user);
		if (remembered) {
			UUID uuid = new UUID();
			String uuidString = java.util.UUID.randomUUID().toString();
			uuid.setUuid(uuidString);
			uuid.setUser(user);
			uuidDao.save(uuid);
			Cookie cookie = new Cookie("uuid", uuidString);
            cookie.setMaxAge(3600 * 24 * 365 * 10); //ten years
            ServletActionContext.getResponse().addCookie(cookie);
            session.setAttribute("uuid", uuidString);
		}
		return true;
	}
	
	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	public void setUuidDao(UUIDDao uuidDao) {
		this.uuidDao = uuidDao;
	}
}