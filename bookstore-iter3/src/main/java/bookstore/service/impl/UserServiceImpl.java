package bookstore.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.BookDao;
import bookstore.dao.CartEntryDao;
import bookstore.dao.OrderDao;
import bookstore.dao.UserDao;
import bookstore.model.Book;
import bookstore.model.CartEntry;
import bookstore.model.Order;
import bookstore.model.OrderEntry;
import bookstore.model.User;
import bookstore.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userDao;
	private CartEntryDao cartEntryDao;
	private BookDao bookDao;
	private OrderDao orderDao;
	
	@Transactional
	public void save(User user) {
		userDao.save(user);
	}
	
	@Transactional
	public void update(User user) {
		userDao.update(user);
	}
	
	@Transactional
	public User get(String username) {
		return userDao.get(username);
	}
	
	@Transactional
	public void addToCart(User user, String ISBN) {
		CartEntry queryEntry = new CartEntry();
		queryEntry.setUser(user);
		queryEntry.setBook(bookDao.get(ISBN));
		CartEntry foundEntry = cartEntryDao.get(queryEntry);
		if (foundEntry != null) {
			foundEntry.setNumber(foundEntry.getNumber() + 1);
			cartEntryDao.update(foundEntry);
		}
		else {
			queryEntry.setNumber(1);
			cartEntryDao.save(queryEntry);
		}
	}
	
	@Transactional
	public void refreshCart(User user) {
		userDao.refreshCart(user);
	}
	
	@Transactional
	public void refreshOrder(User user) {
		userDao.refreshOrder(user);
	}
	
	@Transactional
	public void removeAllBooks(User user, String ISBN) {
		CartEntry queryEntry = new CartEntry();
		queryEntry.setUser(user);
		queryEntry.setBook(bookDao.get(ISBN));
		CartEntry foundEntry = cartEntryDao.get(queryEntry);
		if (foundEntry != null)
			cartEntryDao.delete(foundEntry);
	}
	
	@Transactional
	public void removeOneBook(User user, String ISBN) {
		CartEntry queryEntry = new CartEntry();
		queryEntry.setUser(user);
		queryEntry.setBook(bookDao.get(ISBN));
		CartEntry foundEntry = cartEntryDao.get(queryEntry);
		if (foundEntry != null) {
			int number = foundEntry.getNumber() - 1;
			if (number == 0)
				cartEntryDao.delete(foundEntry);
			else {
				foundEntry.setNumber(number);
				cartEntryDao.update(foundEntry);
			}
		}
	}
	
	@Transactional
	public void payForCart(User user) {
		userDao.refresh(user);
		Set<CartEntry> cart = user.getCart();
		int total_price = 0;
		Set<OrderEntry> orderEntries = new HashSet<OrderEntry>();
		Order order = new Order();
		
		order.setUser(user);
		order.setTime(new Date());
		order.setTotalPrice(total_price);
		order.setEntries(orderEntries);
		orderDao.save(order);
		
		for (CartEntry entry : cart) {
			Book book = entry.getBook();
			total_price += entry.getNumber() * book.getPrice();
			book.setCurrentNumber(book.getCurrentNumber() - entry.getNumber());
			bookDao.update(book);
			OrderEntry orderEntry = new OrderEntry();
			orderEntry.setOrder(order);
			orderEntry.setBook(book);
			orderEntry.setNumber(entry.getNumber());
			orderEntries.add(orderEntry);
			cartEntryDao.delete(entry);
		}
		order.setTotalPrice(total_price);
		user.setBalance(user.getBalance() - total_price);
		user.getOrders().add(order);
		cart.clear();
		userDao.update(user);
	}
	
	@Transactional
	public List<User> listUsers() {
		return userDao.listUsers();
	}
	
	@Transactional
	public List<User> listRelatedUsers(String username) {
		return userDao.listRelatedUsers(username);
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Autowired
	public void setCartEntryDao(CartEntryDao cartEntryDao) {
		this.cartEntryDao = cartEntryDao;
	}
	
	@Autowired
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}