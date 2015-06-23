package bookstore.model;

import java.util.Date;
import java.util.Set;

public class Order {
	private int id;
	private User user;
	private Date time;
	private int totalPrice;
	
	private Set<OrderEntry> entries;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public Set<OrderEntry> getEntries() {
		return entries;
	}

	public void setEntries(Set<OrderEntry> entries) {
		this.entries = entries;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		Order other = (Order) obj;
		if (this.id == other.id)
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return ((Integer)id).hashCode();
	}
}