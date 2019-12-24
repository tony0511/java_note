package com.qf.dao;

import com.qf.pojo.BookInfo;
import com.qf.pojo.BookType;
import com.qf.utils.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Set;

/**
 * Thanks for Everything.
 */
public class BookTypeDAO {

	public void addType(BookType bookType){
		EntityManager entityManager = JPAUtils.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(bookType);
		transaction.commit();
		entityManager.close();

	}

	public BookType findById(Long typeID){
		EntityManager entityManager = JPAUtils.getEntityManager();
		BookType bookType = entityManager.find(BookType.class, typeID);
		//主表
		System.out.println(bookType.getTypeName());
		System.out.println("======================================");
		//关联表
		Set<BookInfo> books = bookType.getBooks();
		for (BookInfo book : books) {
			System.out.println(book.getBookName());
		}


		entityManager.close();
		return bookType;
	}

	public static void main(String[] args) {
		BookType bookType = new BookType();
		bookType.setTypeName("好好学习");
		bookType.setTypeDesc("天天向善");
		BookTypeDAO dao = new BookTypeDAO();
//		dao.addType(bookType);

		dao.findById(30L);
	}



}
