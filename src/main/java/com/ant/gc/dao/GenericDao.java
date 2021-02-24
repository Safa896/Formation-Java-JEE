package com.ant.gc.dao;

import java.util.List;

public interface GenericDao<T,K> {

	public void save(T entity);
	public void update(T entity);
	public void delete(T entity);
	public List<T> findAll();
	public T findById(K id);
}
