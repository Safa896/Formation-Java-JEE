package com.ant.gc.daoimpl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ant.gc.dao.GenericDao;
import com.ant.gc.util.HibernateUtil;

public class GenericDaoImpl<T,K> implements GenericDao<T, K>{
	protected Session session;
	private Transaction tx;
	private Class clazz;
	protected void startOperation() {
		session=HibernateUtil.getInstance().getSessionFactory().openSession();
		tx=session.beginTransaction();
		
	}
	protected void endOperation() {
		tx.commit();
		session.close();
	}
	@Override
	public void save(T entity) {
		startOperation();
		session.save(entity);
		endOperation();
		
	}

	@Override
	public void update(T entity) {
		startOperation();
		session.update(entity);
		endOperation();	
	}

	@Override
	public void delete(T entity) {
		startOperation();
		session.delete(entity);
		endOperation();
		
	}

	@Override
	public List<T> findAll() {
		startOperation();
		List<T> list=session.createCriteria(clazz).list();
		session.close();
		return list;
	}

	public GenericDaoImpl(Class clazz) {
		this.clazz=clazz;
	}
	@Override
	public T findById(K id) {
		startOperation();
		T obj=(T) session.get(clazz,(Serializable) id);
		session.close();
		return obj;
	}

}
