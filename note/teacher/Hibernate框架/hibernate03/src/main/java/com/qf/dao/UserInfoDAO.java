package com.qf.dao;

import com.qf.pojo.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserInfoDAO {

	public void createTable(){
		// 可以验证生成表是否正确
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		factory.close();
	}

	public void add(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("myjpa");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		UserInfo pojo = new UserInfo();
		pojo.setUserName("测试");
		pojo.setUserPass("测试1");
		entityManager.persist(pojo);
		transaction.commit();
		entityManager.close();
		factory.close();

	}

	public static void main(String[] args) {
		UserInfoDAO dao = new UserInfoDAO();
		// dao.add();
		dao.createTable();
	}
}
