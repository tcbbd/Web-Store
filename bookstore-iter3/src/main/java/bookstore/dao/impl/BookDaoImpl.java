package bookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import bookstore.dao.BookDao;
import bookstore.model.Book;

public class BookDaoImpl extends CommonDaoImpl<Book> implements BookDao {
	@SuppressWarnings("unchecked")
	public List<Book> listBooks() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book";
		Query query = session.createQuery(hql);
		return (List<Book>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Book> listRelatedBooks(String title) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Book as b where b.title like :title";
		Query query = session.createQuery(hql);
		query.setString("title", "%" + title + "%");
		return (List<Book>) query.list();
	}
}