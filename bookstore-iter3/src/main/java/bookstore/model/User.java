package bookstore.model;

import java.io.Serializable;
import java.util.Set;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2272463726544934467L;
	
	private String username;
	private String password;
	private String email;
	private String phone;
	private boolean male;
	private boolean admin;
	private boolean removed;
	private int balance;
	
	private Set<CartEntry> cart;
	private Set<Order> orders;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public boolean isMale() {
		return male;
	}
	public void setMale(boolean male) {
		this.male = male;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public boolean isRemoved() {
		return removed;
	}
	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Set<CartEntry> getCart() {
		return cart;
	}
	public void setCart(Set<CartEntry> cart) {
		this.cart = cart;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		User other = (User) obj;
		if (this.username.equals(other.username))
			return true;
		else
			return false;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
}