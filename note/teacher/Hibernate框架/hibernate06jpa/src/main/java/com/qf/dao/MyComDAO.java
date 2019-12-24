package com.qf.dao;

import com.qf.pojo.MyComputer;
import com.qf.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Thanks for Everything.
 */
public class MyComDAO {


	public void findCount(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		String jpql ="select count(comId) from MyComputer ";
		TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
		Long singleResult = query.getSingleResult();
		System.out.println(singleResult);
		entityManager.close();
	}

	public void findAll(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		String jpql ="select  com  from MyComputer com";
		TypedQuery<MyComputer> query = entityManager.createQuery(jpql, MyComputer.class);
		query.setFirstResult(0);//起始位置
		query.setMaxResults(2);//每页大小
		List<MyComputer> resultList = query.getResultList();
		for (MyComputer myComputer : resultList) {
			System.out.println(myComputer.getComName());
		}
		entityManager.close();
	}

	public void findByID(Long id){
		EntityManager entityManager = JPAUtils.getEntityManager();
//		String jpql ="select  com  from MyComputer com where com.comId=:cid";
		String jpql ="select  com  from MyComputer com where com.comId=?1";
		TypedQuery<MyComputer> query = entityManager.createQuery(jpql, MyComputer.class);
//		query.setParameter("cid",id);
		query.setParameter(1,id);
		MyComputer singleResult = query.getSingleResult();
		System.out.println(singleResult.getComName());
		entityManager.close();
	}

	public void findBylike(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		String jpql ="select  com  from MyComputer com where com.comName like :cn";
		TypedQuery<MyComputer> query = entityManager.createQuery(jpql, MyComputer.class);
		query.setParameter("cn","%te%");
		List<MyComputer> resultList = query.getResultList();
		for (MyComputer myComputer : resultList) {
			System.out.println(myComputer.getComName());
		}
		entityManager.close();
	}


	public void findDepart(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		String jpql ="select  com.comName,com.comDesc from MyComputer com";
		TypedQuery<Object[]> query = entityManager.createQuery(jpql, Object[].class);
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			System.out.println(objects[0]+"\t"+objects[1]);
		}
		entityManager.close();
	}


	public void updateCom(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		String jpql ="update MyComputer set comDesc=:cdesc where  comId=:cid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cdesc","最后一次机会超越自己");
		query.setParameter("cid",5L);
		query.executeUpdate();

		transaction.commit();
		entityManager.close();
	}

	public void delCom(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		String jpql ="delete from MyComputer where comId=:cid";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("cid",4L);
		query.executeUpdate();

		transaction.commit();
		entityManager.close();
	}

	public static void main(String[] args) {
		MyComDAO myComDAO = new MyComDAO();
//		myComDAO.findAll();
		myComDAO.findCount();

//		myComDAO.findByID(3L);
//		myComDAO.findBylike();

//		myComDAO.findDepart();

//		myComDAO.updateCom();
//		myComDAO.delCom();
	}
}
