package com.qf.dao;

import com.qf.pojo.BookInfo;
import com.qf.pojo.BookType;
import com.qf.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Thanks for Everything.
 */
public class BookInfoDAO {

	public void  addBook(BookInfo pojo){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(pojo);
		transaction.commit();
		entityManager.close();
	}

	public void findById(Long id){
		EntityManager entityManager = JPAUtils.getEntityManager();
		BookInfo bookInfo = entityManager.find(BookInfo.class, id);
		//主表
		System.out.println(bookInfo.getBookName());
		System.out.println("=================================================");
		//关联表
		BookType bookType = bookInfo.getBookType();
		System.out.println(bookType.getTypeName());
		entityManager.close();
	}



	public static void main(String[] args) {
//		BookInfo pojo = new BookInfo();
//		pojo.setBookName("Java入门到放弃");
//		pojo.setBookAuthor("二货");
//		pojo.setBookDesc("二一回");
//		pojo.setBookPublish("回收站");
//		pojo.setBookPrice(8.9);
//		pojo.setBookDate(System.currentTimeMillis());
//		//关联对象
//		BookType byId = new BookTypeDAO().findById(32L);
//		pojo.setBookType(byId);
		BookInfoDAO dao = new BookInfoDAO();
//		dao.addBook(pojo);

		dao.findById(32L);

	}

}
