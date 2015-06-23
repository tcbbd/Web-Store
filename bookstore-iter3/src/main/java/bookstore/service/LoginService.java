package bookstore.service;

public interface LoginService {
	public boolean login(String username, String password, boolean remembered);
	public String getErrorInfo();
}