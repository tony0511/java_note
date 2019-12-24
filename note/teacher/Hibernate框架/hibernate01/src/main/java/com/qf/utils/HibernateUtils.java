package com.qf.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Thanks for Everything.
 */
public class HibernateUtils {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session openSession(){
		return sessionFactory.openSession();
	}



}
