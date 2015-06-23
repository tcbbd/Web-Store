package bookstore.model;

import java.io.Serializable;

public class OrderEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1678339098418021062L;
	
	private Order order;
	private Book book;
	private int number;
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;
		OrderEntry other = (OrderEntry) obj;
		if (this.order.equals(other.order) && this.book.equals(other.book))
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return (order.getId() + book.getISBN()).hashCode();
	}
}