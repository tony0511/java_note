package com.qf.dao;

import com.qf.pojo.BookInfo;
import com.qf.pojo.BookType;
import com.qf.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.Date;
import java.util.List;

public class BookinfoDAO {

	public void findById(Long bookId){
		Session session = HibernateUtils.openSession();
		BookInfo bookInfo = session.get(BookInfo.class, bookId);
		// 主表信息
		System.out.println(bookInfo.getBookName());
		System.out.println("----------------------------------------------------");
		// // 关联表信息:延迟发送SQL，查询关联表的记录(默认lazy=true)
		// BookType bookTypeByTypeId = bookInfo.getBookTypeByTypeId();
		// // 输出关联表,第二次查询时，二级缓存会再次发出部分SQL
		// System.out.println(bookTypeByTypeId.getTypeName());
		session.close();
		System.out.println("----End------------------------------------------------");
		Session session2 = HibernateUtils.openSession();
		BookInfo bookInfo2 = session2.get(BookInfo.class, bookId);
		// 主表信息
		System.out.println(bookInfo2.getBookName());
		System.out.println("=====================================");
		// // 关联表信息:延迟发送SQL，查询关联表的记录(默认lazy=true)
		// BookType bookTypeByTypeId2 = bookInfo2.getBookTypeByTypeId();
		// // 输出关联表
		// System.out.println(bookTypeByTypeId2.getTypeName());
		session2.close();
		// return bookInfo;
	}

	public void addBook(BookInfo pojo){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(pojo);
		transaction.commit();
		session.close();
	}

	public void findQuey(){
		Session session = HibernateUtils.openSession();
		Query<BookInfo> query = session.createQuery("from BookInfo b left join fetch b.bookTypeByTypeId where b.bookId=10", BookInfo.class);
		query.setCacheable(true);
		List<BookInfo> list = query.getResultList();
		for (BookInfo bookInfo : list) {
			System.out.println(bookInfo.getBookName());
			System.out.println(bookInfo.getBookTypeByTypeId().getTypeName());
		}
		session.close();
		System.out.println("---end-----------------------------------");
		Session session2 = HibernateUtils.openSession();
		Query<BookInfo> query2 = session2.createQuery("from BookInfo b left join fetch b.bookTypeByTypeId where b.bookId=10", BookInfo.class);
		query2.setCacheable(true);
		List<BookInfo> list2 = query2.getResultList();
		for (BookInfo bookInfo2 : list2) {
			System.out.println(bookInfo2.getBookName());
			System.out.println(bookInfo2.getBookTypeByTypeId().getTypeName());
		}
		session.close();
	}

	public static void main(String[] args) {
		BookinfoDAO bookinfoDAO = new BookinfoDAO();
		// // 测试多对一的查询
		// BookInfo bookInfo = bookinfoDAO.findById(10L);
		// // 是否可以拿到关联的对象
		// // 主表信息
		// System.out.println(bookInfo.getBookName());
		// // 关联表信息
		// BookType bookTypeByTypeId = bookInfo.getBookTypeByTypeId();
		// // 输出关联表
		// System.out.println(bookTypeByTypeId.getTypeName());

		// // 多对一的添加
		// BookInfo pojo  = new BookInfo();
		// pojo.setBookName("Java1718");
		// pojo.setBookAuthor("Java1718");
		// pojo.setBookPrice(17.18);
		// pojo.setBookDate(new Date().getTime());
		// pojo.setBookPublish("java1718");
		// pojo.setBookDesc("Java1718...");
		// // 得到关联对象
		// BookType byId = new BookTypeDAO().findById(5L);
		// // 关联字段是对象
		// pojo.setBookTypeByTypeId(byId);
		// bookinfoDAO.addBook(pojo);
		bookinfoDAO.findQuey();
	}

}
