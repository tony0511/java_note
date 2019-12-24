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
		Configuration configuration = new Configuration().configure("com/qf/utils/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session openSession(){
		return sessionFactory.openSession();
	}

	//获取session方式二，使用这个session必须开启事务
	public static Session getCuurentSession(){
		//受线程绑定，也就是在多线程环境下，是线程安全的。
		return sessionFactory.getCurrentSession();

	}



}
