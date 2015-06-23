package bookstore.service;

import java.util.List;

import bookstore.model.User;

public interface UserService {
	public void save(User user);
	public void update(User user);
	public User get(String username);
	public void addToCart(User user, String ISBN);
	public void refreshCart(User user);
	public void refreshOrder(User user);
	public void removeAllBooks(User user, String ISBN);
	public void removeOneBook(User user, String ISBN);
	public void payForCart(User user);
	public List<User> listUsers();
	public List<User> listRelatedUsers(String username);
}