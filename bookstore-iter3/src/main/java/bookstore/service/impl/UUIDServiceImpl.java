package bookstore.service.impl;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bookstore.dao.UUIDDao;
import bookstore.model.UUID;
import bookstore.service.UUIDService;

public class UUIDServiceImpl implements UUIDService {
	private UUIDDao uuidDao;
	
	@Transactional
	public UUID get(String id) {
		UUID uuid = uuidDao.get(id);
		Hibernate.initialize(uuid.getUser());
		return uuid;
	}
	
	@Transactional
	public void delete(String id) {
		uuidDao.delete(id);
	}
	
	@Autowired
	public void setUuidDao(UUIDDao uuidDao) {
		this.uuidDao = uuidDao;
	}
}
