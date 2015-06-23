package bookstore.service;

import bookstore.model.UUID;

public interface UUIDService {
	public UUID get(String id);
	public void delete(String id);
}