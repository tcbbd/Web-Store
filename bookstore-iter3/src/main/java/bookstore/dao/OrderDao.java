package bookstore.dao;

import java.util.List;

import bookstore.model.Order;

public interface OrderDao extends CommonDao<Order> {
	public List<Order> listOrders();
	public List<Object[]> statisticsByUser();
	public List<Object[]> statisticsByCategory();
	public List<Object[]> statisticsByDay();
	public List<Object[]> statisticsByMonth();
	public List<Object[]> statisticsByYear();
}