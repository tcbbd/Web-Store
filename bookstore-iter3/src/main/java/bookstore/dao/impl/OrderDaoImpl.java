package bookstore.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import bookstore.dao.OrderDao;
import bookstore.model.Order;

public class OrderDaoImpl extends CommonDaoImpl<Order> implements OrderDao {
	@SuppressWarnings("unchecked")
	public List<Order> listOrders() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Order";
		Query query = session.createQuery(hql);
		return (List<Order>) query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> statisticsByUser() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select sum(price * number) as total, sum(number) as number, username, isremoved from orders natural join bought natural join user natural join book group by username;";
		SQLQuery query = session.createSQLQuery(sql);		
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> statisticsByCategory() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select sum(price * number) as total, sum(number) as number, category from orders natural join bought natural join book group by category;";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> statisticsByDay() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select sum(price * number) as total, sum(number) as number, date(time) as day from orders natural join bought natural join book group by date(time);";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> statisticsByMonth() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select sum(price * number) as total, sum(number) as number, year(time) as year, month(time) as month from orders natural join bought natural join book group by year(time), month(time);";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Object[]> statisticsByYear() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "select sum(price * number) as total, sum(number) as number, year(time) as year from orders natural join bought natural join book group by year(time);";
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return query.list();
	}
}