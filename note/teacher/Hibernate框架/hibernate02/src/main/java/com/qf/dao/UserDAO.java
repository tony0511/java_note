package com.qf.dao;

import com.qf.pojo.UserinfoEntity;
import com.qf.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;

public class UserDAO {

	// 添加数据
	public void addUser(UserinfoEntity pojo){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pojo);
		transaction.commit();
		session.close();
	}

	// 根据主键查询数据
	public void findById(Long uid){
		Session session = HibernateUtils.openSession();
		UserinfoEntity userinfoEntity = session.get(UserinfoEntity.class, uid);
		System.out.println(userinfoEntity.getUserName() + "\t" + userinfoEntity.getUserPass());
		session.close();
	}

	// 索引占位查询
	public void findByIdHql(Long uid){
		Session session = HibernateUtils.openSession();
		Query<UserinfoEntity> query = session.createQuery("from UserinfoEntity where uid=?", UserinfoEntity.class);
		// 设置参数值
		query.setParameter(0, uid);
		// 取得单个对象
		UserinfoEntity userinfoEntity = query.uniqueResult();
		System.out.println(userinfoEntity.getUserName() + "\t" + userinfoEntity.getUserPass());
		session.close();
	}

	// 命名占位查询
	public void findByIdHqlByName(Long uid){
		Session session = HibernateUtils.openSession();
		Query<UserinfoEntity> query = session.createQuery("from UserinfoEntity where uid=:uid", UserinfoEntity.class);
		// 设置参数值
		query.setParameter("uid", uid);
		// 取得单个对象
		UserinfoEntity userinfoEntity = query.uniqueResult();
		System.out.println(userinfoEntity.getUserName() + "\t" + userinfoEntity.getUserPass());
		session.close();
	}

	// 查询表数据
	public void findAll(){
		Session session = HibernateUtils.openSession();
		// String hql = "from UserinfoEntity"; // 找对象不是表
		String hql = "select ue from UserinfoEntity ue"; // 找对象不是表
		Query<UserinfoEntity> query = session.createQuery(hql, UserinfoEntity.class);
		List<UserinfoEntity> resultList = query.getResultList();
		for (UserinfoEntity userinfoEntity : resultList) {
			System.out.println(userinfoEntity.getUid() + "\t" + userinfoEntity.getUserName() + "\t" + userinfoEntity.getUserPass());
		}
		session.close();
	}

	// 分页查询
	public void findByPage(int start, int size){
		Session session = HibernateUtils.openSession();
		String hql = "from UserinfoEntity"; // 找对象不是表
		Query<UserinfoEntity> query = session.createQuery(hql, UserinfoEntity.class);
		// 设置起始位置
		query.setFirstResult(start);
		// 设置每次取多少条记录
		query.setMaxResults(size);
		List<UserinfoEntity> resultList = query.getResultList();
		for (UserinfoEntity userinfoEntity : resultList) {
			System.out.println(userinfoEntity.getUid() + "\t" + userinfoEntity.getUserName() + "\t" + userinfoEntity.getUserPass());
		}
		session.close();
	}

	// 使用 currentSession 查询
	public void findByIdHqlByCurrentSession(Long uid){
		Session session = HibernateUtils.getCurrentSession();
		// 使用 currentSession 必须开启事务
		Transaction transaction = session.beginTransaction();
		Query<UserinfoEntity> query = session.createQuery("from UserinfoEntity where uid=:uid", UserinfoEntity.class);
		query.setReadOnly(true); // 可以设置事务为只读
		// 设置参数值
		query.setParameter("uid", uid);
		// 取得单个对象
		UserinfoEntity userinfoEntity = query.uniqueResult();
		System.out.println(userinfoEntity.getUserName() + "\t" + userinfoEntity.getUserPass());
		transaction.commit();
		// session.close(); // 不用关闭连接，session 和线程是绑定的，线程会关闭 session
	}

	public void testSession(){
		// 在用一个线程内，用 HibernateUtils.getCurrentSession() 取得到的是一样的 session
		Session cuurentSession = HibernateUtils.getCurrentSession();
		Session cuurentSession1 = HibernateUtils.getCurrentSession();
		System.out.println("对比结果：");
		System.out.println(cuurentSession == cuurentSession1); // true
		Session session = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		System.out.println("openSession对比结果：");
		System.out.println(session == session2); // false
	}

	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		// UserinfoEntity pojo = new UserinfoEntity();
		// pojo.setUserName("我要睡觉");
		// pojo.setUserPass("如何对治睡觉？");
		// userDAO.addUser(pojo);
		// userDAO.findById(42L);
		// userDAO.findAll();
		// userDAO.findByPage(20, 10); // 第三页
		// userDAO.findByIdHql(42L);
		// userDAO.findByIdHqlByCurrentSession(42L);
		userDAO.testSession();
	}
}
