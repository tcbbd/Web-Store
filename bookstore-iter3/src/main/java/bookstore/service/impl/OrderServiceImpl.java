package bookstore.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.OrderDao;
import bookstore.model.Order;
import bookstore.service.OrderService;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao;
	
	@Transactional
	public List<Order> listOrders() {
		return orderDao.listOrders();
	}
	
	@Transactional
	public Order getOrder(String orderID) {
		int id = Integer.parseInt(orderID);
		Order order = orderDao.get(id);
		Hibernate.initialize(order.getEntries());
		Hibernate.initialize(order.getUser());
		return order;
	}
	
	@Transactional
	public List<Object[]> statisticsByUser() {
		return orderDao.statisticsByUser();
	}
	
	@Transactional
	public List<Object[]> statisticsByCategory() {
		return orderDao.statisticsByCategory();
	}
	
	@Transactional
	public List<Object[]> statisticsByDay() {
		return orderDao.statisticsByDay();
	}
	
	@Transactional
	public List<Object[]> statisticsByMonth() {
		return orderDao.statisticsByMonth();
	}
	
	@Transactional
	public List<Object[]> statisticsByYear() {
		return orderDao.statisticsByYear();
	}
	
	@Autowired
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
}