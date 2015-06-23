package bookstore.service;

import java.util.List;

import bookstore.model.Order;

public interface OrderService {
	public List<Order> listOrders();
	public Order getOrder(String orderID);
	public List<Object[]> statisticsByUser();
	public List<Object[]> statisticsByCategory();
	public List<Object[]> statisticsByDay();
	public List<Object[]> statisticsByMonth();
	public List<Object[]> statisticsByYear();
}