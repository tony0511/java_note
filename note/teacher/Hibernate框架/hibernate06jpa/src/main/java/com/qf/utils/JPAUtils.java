package com.qf.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Thanks for Everything.
 */
public class JPAUtils {
	private static EntityManagerFactory entityManagerFactory;
	static {
		entityManagerFactory = Persistence.createEntityManagerFactory("myjpa");
	}

	public static EntityManager getEntityManager(){
		return entityManagerFactory.createEntityManager();
	}


}
