package bookstore.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import bookstore.dao.CommonDao;

public class CommonDaoImpl<T> implements CommonDao<T> {
	private Class<T> entityClass;
	protected SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public CommonDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		entityClass = (Class<T>) ((ParameterizedType) t).getActualTypeArguments()[0];
	}
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
	}
	
	public void delete(T object) {
		sessionFactory.getCurrentSession().delete(object);
	}
	
	public void delete(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(session.get(entityClass, id));
	}
	
	public void update(T object) {
		sessionFactory.getCurrentSession().update(object);
	}
	
	public void refresh(T object) {
		sessionFactory.getCurrentSession().refresh(object);
	}
	
	@SuppressWarnings("unchecked")
	public T get(Serializable id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(entityClass, id);
	}
}
