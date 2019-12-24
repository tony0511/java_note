package com.qf.dao;

import com.qf.pojo.UserinfoEntity;
import com.qf.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Thanks for Everything.
 */
public class UserDAO {

	public void addUser(UserinfoEntity pojo){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pojo);
		transaction.commit();
		session.close();
	}

	public void findById(Long uid){
		Session session = HibernateUtils.openSession();
		UserinfoEntity userinfoEntity = session.get(UserinfoEntity.class, uid);
		System.out.println(userinfoEntity.getUserName()+"\t"+userinfoEntity.getUserPass());
		session.close();
	}

	public void findByIdHql(Long uid){
		Session session = HibernateUtils.openSession();
		Query<UserinfoEntity> query = session.createQuery("from UserinfoEntity where uid=?", UserinfoEntity.class);
		//设置参数值
		query.setParameter(0,uid);
		//取得单个对象
		UserinfoEntity userinfoEntity = query.uniqueResult();
		System.out.println(userinfoEntity.getUserName()+"\t"+userinfoEntity.getUserPass());
		session.close();
	}

	public void findByIdHqlByName(Long uid){
		Session session = HibernateUtils.openSession();
		Query<UserinfoEntity> query = session.createQuery("from UserinfoEntity where uid=:uid", UserinfoEntity.class);
		//设置参数值
		query.setParameter("uid",uid);
		//取得单个对象
		UserinfoEntity userinfoEntity = query.uniqueResult();
		System.out.println(userinfoEntity.getUserName()+"\t"+userinfoEntity.getUserPass());
		session.close();
	}

	public void findAll(){
		Session session = HibernateUtils.openSession();
//		String hql = "from UserinfoEntity";//找对象不是表
		String hql = "select ue from UserinfoEntity ue";//找对象不是表
		Query<UserinfoEntity> query = session.createQuery(hql, UserinfoEntity.class);
		List<UserinfoEntity> resultList = query.getResultList();
		for (UserinfoEntity userinfoEntity : resultList) {
			System.out.println(userinfoEntity.getUid()+"\t"+userinfoEntity.getUserName()+"\t"+userinfoEntity.getUserPass());
		}
		session.close();
	}

	public void findByPage(int start,int size){
		Session session = HibernateUtils.openSession();
		String hql = "from UserinfoEntity";//找对象不是表
		Query<UserinfoEntity> query = session.createQuery(hql, UserinfoEntity.class);
		//设置起始位置
		query.setFirstResult(start);
		// 设置每次取多少条记录
		query.setMaxResults(size);
		List<UserinfoEntity> resultList = query.getResultList();
		for (UserinfoEntity userinfoEntity : resultList) {
			System.out.println(userinfoEntity.getUid()+"\t"+userinfoEntity.getUserName()+"\t"+userinfoEntity.getUserPass());
		}
		session.close();
	}

	public void findByIdHqlByCurrenSession(Long uid){
		Session session = HibernateUtils.getCuurentSession();
		Transaction transaction = session.beginTransaction();
		Query<UserinfoEntity> query = session.createQuery("from UserinfoEntity where uid=:uid", UserinfoEntity.class);
		query.setReadOnly(true);//可以设置事务为只读
		//设置参数值
		query.setParameter("uid",uid);
		//取得单个对象
		UserinfoEntity userinfoEntity = query.uniqueResult();
		System.out.println(userinfoEntity.getUserName()+"\t"+userinfoEntity.getUserPass());
		transaction.commit();
//		session.close();
	}

	public void testSession(){
		//在用一个线程内，用HibernateUtils.getCuurentSession()取得到的是一样的session
		Session cuurentSession = HibernateUtils.getCuurentSession();
		System.out.println(cuurentSession);
		Session cuurentSession1 = HibernateUtils.getCuurentSession();
		System.out.println(cuurentSession1);
		System.out.println("对比结果：");
		System.out.println(cuurentSession==cuurentSession1);
		Session session = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		System.out.println("openSession对比结果：");
		System.out.println(session==session2);

	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
//		UserinfoEntity pojo = new UserinfoEntity();
//		pojo.setUserName("我要睡觉");
//		pojo.setUserPass("如何对治睡觉？");
//		userDAO.addUser(pojo);

//		userDAO.findById(42L);
//		userDAO.findAll();
		//第三页
//		userDAO.findByPage(20,10);

//		userDAO.findByIdHql(42L);
//		userDAO.findByIdHqlByCurrenSession(42L);
		userDAO.testSession();
	}
}
