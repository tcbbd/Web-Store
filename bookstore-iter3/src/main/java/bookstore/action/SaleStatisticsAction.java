package bookstore.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.Order;
import bookstore.model.User;
import bookstore.service.OrderService;

public class SaleStatisticsAction {
	private String method;
	private String orderID;
	private int total_price;
	
	private List<Order> orders;
	private Order order;
	
	private List<Object[]> result;
	
	private OrderService orderService;
	
	public String execute() throws Exception {
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (!user.isAdmin())
			return "index";
		
		if (method == null) {
			if (orderID == null) {
				orders = orderService.listOrders();
				total_price = 0;
				for (Order order : orders)
					total_price += order.getTotalPrice();
				return "list";
			}
			else {
				order = orderService.getOrder(orderID);
				orderID = null;
				return "order";
			}
		}
		else {
			if (method.equals("byuser")) {
				result = orderService.statisticsByUser();
				method = orderID = null;
				return "byuser";
			}
			else if (method.equals("bycategory")) {
				result = orderService.statisticsByCategory();
				method = orderID = null;
				return "bycategory";
			}
			else if (method.equals("byday")) {
				result = orderService.statisticsByDay();
				method = orderID = null;
				return "byday";
			}
			else if (method.equals("bymonth")) {
				result = orderService.statisticsByMonth();
				method = orderID = null;
				return "bymonth";
			}
			else if (method.equals("byyear")) {
				result = orderService.statisticsByYear();
				method = orderID = null;
				return "byyear";
			}
			return "index";
		}
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getTotal_price() {
		return total_price;
	}

	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public List<Object[]> getResult() {
		return result;
	}

	public void setResult(List<Object[]> result) {
		this.result = result;
	}
}