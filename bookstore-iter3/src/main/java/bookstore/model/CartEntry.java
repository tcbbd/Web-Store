package bookstore.model;

import java.io.Serializable;

public class CartEntry implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5330581048094312183L;
	
	private User user;
	private Book book;
	private int number;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
		CartEntry other = (CartEntry) obj;
		if (this.user.equals(other.user) && this.book.equals(other.book))
			return true;
		else
			return false;
	}
	
	@Override
	public int hashCode() {
		return (user.getUsername() + book.getISBN()).hashCode();
	}
}