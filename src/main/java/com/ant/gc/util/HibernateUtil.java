package com.ant.gc.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static HibernateUtil instance;
	private SessionFactory sessionFactory;

	private HibernateUtil() {

		if (sessionFactory == null) {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder serviceRegistryBuilder 
			= new StandardServiceRegistryBuilder();
			
			serviceRegistryBuilder.applySettings(configuration.getProperties());
			StandardServiceRegistry standardServiceRegistry 
			= serviceRegistryBuilder.build();
			
			sessionFactory = configuration.buildSessionFactory(standardServiceRegistry);
		
		}

	}

	public static HibernateUtil getInstance() {
		if (instance == null) {
			instance = new HibernateUtil();
		}
		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
