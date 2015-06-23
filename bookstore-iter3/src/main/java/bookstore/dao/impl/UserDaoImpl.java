package bookstore.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;

import bookstore.dao.UserDao;
import bookstore.model.User;

public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {
	public void refreshCart(User user) {
		refresh(user);
		Hibernate.initialize(user.getCart());
	}
	
	public void refreshOrder(User user) {
		refresh(user);
		Hibernate.initialize(user.getOrders());
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listUsers() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User";
		Query query = session.createQuery(hql);
		return (List<User>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<User> listRelatedUsers(String username) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from User as u where u.username like :username";
		Query query = session.createQuery(hql);
		query.setString("username", "%" + username + "%");
		return (List<User>) query.list();
	}
}