package com.qf.dao;

import com.qf.pojo.BookInfoEntity;
import com.qf.pojo.BookTypeEntity;
import com.qf.pojo.MyComputer;
import com.qf.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Thanks for Everything.
 */
public class MyComputerDAO {

	public void initTable(){
		//加载配置，得到工厂
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myjpa");
		entityManagerFactory.close();
	}

	public void addCom(){
		//第一步：加载配置，得到工厂
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myjpa");
		//第二步：得到实体管理对象
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//第三步：开启事务
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		//第四步：操作数据
		MyComputer pojo = new MyComputer();
		pojo.setComName("联想");
		pojo.setComDesc("支持国产");
		entityManager.persist(pojo);
		//第五步：提交事务
		transaction.commit();
		//第六步：关闭链接
		entityManager.close();
		entityManagerFactory.close();
	}

	public void findById(Long cid){
		EntityManager entityManager = JPAUtils.getEntityManager();
		MyComputer myComputer = entityManager.find(MyComputer.class, cid);
		System.out.println(myComputer.getComName()+"\t"+myComputer.getComDesc());
		entityManager.close();
	}

	public void updateCom(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		MyComputer myComputer = entityManager.find(MyComputer.class, 2L);
		myComputer.setComDesc("中国梦");

		entityManager.merge(myComputer);
		transaction.commit();
		entityManager.close();

	}

	public void del(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		MyComputer myComputer = entityManager.find(MyComputer.class, 1L);
		entityManager.remove(myComputer);
		transaction.commit();
		entityManager.close();
	}

	public void addType(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		BookTypeEntity pojo = new BookTypeEntity();
		pojo.setTypeName("测试");
		pojo.setTypeDesc("ha");
		entityManager.persist(pojo);

		transaction.commit();
		entityManager.close();
	}

	public void addBook(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		BookInfoEntity pojo = new BookInfoEntity();
		pojo.setBookName("tt");
		pojo.setBookAuthor("测试");
		pojo.setBookDate(System.currentTimeMillis());
		pojo.setBookDesc("ttt");
		pojo.setBookPrice(3.4);
		pojo.setBookPublish("清华");
		BookTypeEntity bookTypeEntity = entityManager.find(BookTypeEntity.class, 1L);
		pojo.setBookTypeByTypeId(bookTypeEntity);
		entityManager.persist(pojo);

		transaction.commit();
		entityManager.close();
	}

	public void findByBook(){
		EntityManager entityManager = JPAUtils.getEntityManager();
		BookInfoEntity bookInfoEntity = entityManager.find(BookInfoEntity.class, 1L);
		System.out.println(bookInfoEntity.getBookName());
		System.out.println("=================================");
		BookTypeEntity bookTypeByTypeId = bookInfoEntity.getBookTypeByTypeId();
		System.out.println(bookTypeByTypeId.getTypeName());
	}

	public static void main(String[] args) {
		MyComputerDAO dao = new MyComputerDAO();
//		dao.initTable();
//		dao.addCom();
//		dao.findById(1L);
//		dao.updateCom();
//		dao.del();
//		dao.addType();
//		dao.addBook();
		dao.findByBook();
	}

}
