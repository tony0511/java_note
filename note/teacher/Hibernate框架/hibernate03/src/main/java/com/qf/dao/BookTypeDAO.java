package com.qf.dao;

import com.qf.pojo.BookInfo;
import com.qf.pojo.BookType;
import com.qf.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Collection;
import java.util.Date;

public class BookTypeDAO {

	public BookType findById(Long typeId){
		Session session = HibernateUtils.openSession();
		BookType bookType = session.get(BookType.class, typeId);
		System.out.println(bookType.getTypeName()); // 主表分类信息
		System.out.println("=====================================================");
		// 分类对应的图书,默认lazy=true,延迟发送SQL
		Collection<BookInfo> bookInfosByTypeId = bookType.getBookInfosByTypeId();
		for (BookInfo bookInfo : bookInfosByTypeId) {
			System.out.println(bookInfo.getBookName());
		}
		session.close();
		return bookType;
	}

	// 添加分类的同时，添加图书，在 one 方完成所有的更新
	public  void  addType(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		BookType pojo = new BookType();
		pojo.setTypeName("Java1718");
		pojo.setTypeDesc("Java1718");

		// 可否同时添加关联的图书呢
		BookInfo bookInfo1 = new BookInfo();
		bookInfo1.setBookName("不睡觉");
		bookInfo1.setBookAuthor("睡觉");
		bookInfo1.setBookDesc("好困难");
		bookInfo1.setBookPublish("Java1718");
		bookInfo1.setBookPrice(1718.0);
		bookInfo1.setBookDate(new Date().getTime());

		pojo.getBookInfosByTypeId().add(bookInfo1);

		BookInfo bookInfo2 = new BookInfo();
		bookInfo2.setBookName("对治睡觉");
		bookInfo2.setBookAuthor("如何睡觉");
		bookInfo2.setBookDesc("爱睡觉");
		bookInfo2.setBookPublish("Java1718");
		bookInfo2.setBookPrice(1718.0);
		bookInfo2.setBookDate(new Date().getTime());

		pojo.getBookInfosByTypeId().add(bookInfo2);

		session.save(pojo);
		transaction.commit();
		session.close();
	}

	public void delAll(Long typeId){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		BookType bookType = session.get(BookType.class, typeId);
		session.delete(bookType);
		transaction.commit();
		session.close();
	}
	// 单表的延迟与立即，只关心主表
	public void findByIdLazy(Long typeId){ // 调试直接加载了，需要运行测试
		Session session = HibernateUtils.openSession();
		// get 方法立即检索，立即执行 SQL 语句查询所有字段的数据。无数据返回 null
		BookType bookType = session.get(BookType.class, typeId);
		// load 方法延迟检索，如果只使用 OID 的值不进行查询，如果要使用其他属性值才将执行 SQL 语句查询，如果没有数据抛异常。
		// BookType bookType = session.load(BookType.class, typeId);
		System.out.println("========================================="); // Idea中测试
		System.out.println(bookType.getTypeName());
		session.close();
	}

	public static void main(String[] args) {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType byId = bookTypeDAO.findById(30L);
		// bookTypeDAO.addType();
		// bookTypeDAO.delAll(28L);
		// bookTypeDAO.findByIdLazy(30L);
	}

}
