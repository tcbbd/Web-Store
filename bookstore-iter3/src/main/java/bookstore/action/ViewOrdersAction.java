package bookstore.action;

import java.util.Set;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.model.Order;
import bookstore.model.User;
import bookstore.service.OrderService;
import bookstore.service.UserService;

public class ViewOrdersAction {
	private String orderID;
	private int total;
	private Order order;
	
	private UserService userService;
	private OrderService orderService;
	
	public String execute() throws Exception {
		if (!(Boolean) ServletActionContext.getRequest().getSession().getAttribute("isLogin"))
			return "index";
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		if (user.isAdmin())
			return "index";
		if (orderID == null) {
			userService.refreshOrder(user);
			Set<Order> orders = user.getOrders();
			total = 0;
			for (Order order : orders)
				total += order.getTotalPrice();
			return "list";
		}
		else {
			order = orderService.getOrder(orderID);
			orderID = null;
			return "selected";	
		}
	}
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}