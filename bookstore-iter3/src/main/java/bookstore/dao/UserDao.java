package bookstore.dao;

import java.util.List;

import bookstore.model.User;

public interface UserDao extends CommonDao<User> {
	public void refreshCart(User user);
	public void refreshOrder(User user);
	public List<User> listUsers();
	public List<User> listRelatedUsers(String username);
}