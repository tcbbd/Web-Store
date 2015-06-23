package bookstore.dao;

import java.io.Serializable;

public interface CommonDao<T> {
	public void save(T t);	
	public T get(Serializable id);
	public void delete(T object);
	public void delete(Serializable id);
	public void update(T object);
	public void refresh(T object);
}
