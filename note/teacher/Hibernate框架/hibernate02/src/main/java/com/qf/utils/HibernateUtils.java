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

	// 获取 session 方式二，使用这个 session 必须开启事务
	public static Session getCurrentSession(){
		// 受线程绑定，也就是在多线程环境下，是线程安全的。
		return sessionFactory.getCurrentSession();
	}

}
