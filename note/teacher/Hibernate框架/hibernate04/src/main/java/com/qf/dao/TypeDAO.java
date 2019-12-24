package com.qf.dao;

import com.qf.pojo.BookInfoEntity;
import com.qf.pojo.BookTypeEntity;
import com.qf.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.Collection;
import java.util.List;

/**
 * Thanks for Everything.
 */
public class TypeDAO {

	public void addType(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		BookTypeEntity bookTypeEntity = new BookTypeEntity();
		bookTypeEntity.setTypeName("放下");
		bookTypeEntity.setTypeDesc("外在的放下与内心的放下");//这个POJO对象此时就是 2.1.瞬时态

		session.save(bookTypeEntity);//这个时候，这个对象就是 持久态
		System.out.println(bookTypeEntity.getTypeId());

		transaction.commit();
		session.close();

		System.out.println(bookTypeEntity.getTypeId());//这个时候，这个对象就是 游离态
	}

	public void updateType(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		BookTypeEntity bookTypeEntity = session.get(BookTypeEntity.class, 31L);
		bookTypeEntity.setTypeName("真的放下");
//		session.update(bookTypeEntity);//不调用更新也可以更新内容
		transaction.commit();//提交事务后会对比
		session.close();
	}

	public void testOneCache(){
		Session session = HibernateUtils.openSession();
		//第一次查询,找DB，打印SQL
		BookTypeEntity bookTypeEntity = session.get(BookTypeEntity.class, 31L);
		System.out.println(bookTypeEntity.getTypeName());

		// 第二次查询，直接找缓存，不到DB，不打印SQL
		BookTypeEntity bookTypeEntity2 = session.get(BookTypeEntity.class, 31L);
		System.out.println(bookTypeEntity2.getTypeName());

		session.clear();//清空缓存
		// 第三次查询，直接找缓存没记录，找DB，打印SQL
		BookTypeEntity bookTypeEntity3 = session.get(BookTypeEntity.class, 31L);
		System.out.println(bookTypeEntity3.getTypeName());
		session.close();
	}

	public void findByHQL(){
		Session session = HibernateUtils.openSession();
//		String hql = "from BookTypeEntity where typeName like :tn";
		String hql = "from BookTypeEntity where typeId > ?";//条件是ＰＯＪＯ中的属性名称，不是字段名称
		Query<BookTypeEntity> query = session.createQuery(hql, BookTypeEntity.class);
//		query.setParameter("tn","%人工%");
		query.setParameter(0,29L);
		List<BookTypeEntity> resultList = query.getResultList();
		for (BookTypeEntity bookTypeEntity : resultList) {
			System.out.println(bookTypeEntity.getTypeName()+"\t"+bookTypeEntity.getTypeDesc());
		}
		session.close();
	}

	public void testUpdateHql(){
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
//		String hql = "update BookTypeEntity set typeDesc=? where typeId=?";
		String hql = "delete from BookTypeEntity where typeId=?";
		Query query = session.createQuery(hql);
//		query.setParameter(0,"提升自己");
//		query.setParameter(1,30L);
		query.setParameter(0,29L);
		query.executeUpdate();

		transaction.commit();
		session.close();
	}

	public void find1(){
		Session session = HibernateUtils.openSession();
		//如果是一个字段，可以指定这个字段的类型
		Query<String> query = session.createQuery("select typeName from BookTypeEntity", String.class);
		List<String> resultList = query.getResultList();
		for (String s : resultList) {
			System.out.println(s);
		}
		session.close();
	}

	public void find2(){
		Session session = HibernateUtils.openSession();
//		String hql = "select book.bookTypeByTypeId from  BookInfoEntity book where book.bookTypeByTypeId.typeId=1 ";
//		String hql2 ="from BookTypeEntity where typeId=1";
		//如果查询部分字段
		Query<Object[]> query = session.createQuery("select typeName,typeDesc from BookTypeEntity", Object[].class);
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			System.out.println(objects[0]+"\t"+objects[1]);
		}
		session.close();
	}

	public void findCount(){
		Session session = HibernateUtils.openSession();
		Query<Long> query = session.createQuery("select count(*) from BookTypeEntity", Long.class);
		Long aLong = query.uniqueResult();
		System.out.println(aLong);
		session.close();
	}

	public void find5(){
		Session session = HibernateUtils.openSession();
		//迫切外链接
//		String hql = "from BookInfoEntity book left join fetch book.bookTypeByTypeId ";
		String hql = "from BookInfoEntity book inner join fetch book.bookTypeByTypeId ";
		Query<BookInfoEntity> query = session.createQuery(hql, BookInfoEntity.class);
		List<BookInfoEntity> resultList = query.getResultList();
		for (BookInfoEntity bookInfoEntity : resultList) {
			//主表
			System.out.println(bookInfoEntity.getBookName());
			//关联表
			BookTypeEntity bookTypeByTypeId = bookInfoEntity.getBookTypeByTypeId();
			System.out.println("关联分类:"+bookTypeByTypeId.getTypeName());
		}

		session.close();
	}

	public void findSql(){
		Session session = HibernateUtils.openSession();
		String sql = "select * from book_type";
		NativeQuery<BookTypeEntity> nativeQuery = session.createNativeQuery(sql, BookTypeEntity.class);
		List<BookTypeEntity> list = nativeQuery.list();
		for (BookTypeEntity bookTypeEntity : list) {
			System.out.println(bookTypeEntity.getTypeName()+"\t"+bookTypeEntity.getTypeDesc());
		}
		session.close();
	}

	public void testTwoCache(){
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		BookTypeEntity bookTypeEntity = session1.get(BookTypeEntity.class, 30L);
		System.out.println(bookTypeEntity.getTypeName());
		//关联表
		Collection<BookInfoEntity> bookInfosByTypeId = bookTypeEntity.getBookInfosByTypeId();
		for (BookInfoEntity bookInfoEntity : bookInfosByTypeId) {
			System.out.println(bookInfoEntity.getBookName());
		}
		session1.close();
		System.out.println("============================================================");
		//第二次查询 走二级缓存，不查DB
		BookTypeEntity bookTypeEntity2 = session2.get(BookTypeEntity.class, 30L);
		System.out.println(bookTypeEntity2.getTypeName());
		//关联表
		Collection<BookInfoEntity> bookInfosByTypeId2 = bookTypeEntity2.getBookInfosByTypeId();
		for (BookInfoEntity bookInfoEntity : bookInfosByTypeId2) {
			System.out.println(bookInfoEntity.getBookName());
		}
		session2.close();

	}

	public  void testQueyCache(){
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		String hql = "from BookTypeEntity where typeId=:tid";
		Query<BookTypeEntity> query = session1.createQuery(hql, BookTypeEntity.class);
		query.setParameter("tid",31L);
		//开启查询缓存
		query.setCacheable(true);
		BookTypeEntity singleResult = query.getSingleResult();//获取单条记录
		System.out.println(singleResult.getTypeName());
		session1.close();
		//第二次查询
		Query<BookTypeEntity> query2 = session2.createQuery(hql, BookTypeEntity.class);
		query2.setParameter("tid",31L);
		//开启查询缓存
		query2.setCacheable(true);
		BookTypeEntity singleResult2 = query2.getSingleResult();//获取单条记录
		System.out.println(singleResult2.getTypeName());
		session2.close();

	}

	public static void main(String[] args) {
		TypeDAO typeDAO = new TypeDAO();
//		typeDAO.addType();
//		typeDAO.updateType();
//		typeDAO.testOneCache();
//		typeDAO.findByHQL();
//		typeDAO.testUpdateHql();
//		typeDAO.find1();
//		typeDAO.find2();
//		typeDAO.findCount();
//		typeDAO.find5();
//		typeDAO.findSql();
//		typeDAO.testTwoCache();
		typeDAO.testQueyCache();
	}

}
