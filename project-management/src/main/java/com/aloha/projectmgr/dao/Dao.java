package com.aloha.projectmgr.dao;

public interface Dao {
	
	public void save(Object object);
	
	public void persist(Object object); 

	public void update(Object object);

	public void saveOrUpdate(Object object);
	
	public void delete(Object object);
}
