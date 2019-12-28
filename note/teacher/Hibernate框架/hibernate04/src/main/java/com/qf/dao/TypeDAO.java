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

	// POJO 状态：瞬时态 -> 持久态 -> 游离态
	public void addType() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		BookTypeEntity bookTypeEntity = new BookTypeEntity();
		bookTypeEntity.setTypeName("放下");
		bookTypeEntity.setTypeDesc("外在的放下与内心的放下");
		// 此时这个 POJO 对象是 瞬时态，POJO 对象中还没有生成 OID，也没有被 Session 管理
		session.save(bookTypeEntity);
		// 此时这个 POJO 对象是 持久态，POJO 对象中已生成 OID，也被 Session 管理
		System.out.println(bookTypeEntity.getTypeId());
		transaction.commit();
		session.close();
		// 此时这个 POJO 对象是 游离态，已生成的 OID 还在 POJO 对象中，但没有被 Session 管理，因为 session 已经 close 了
		System.out.println(bookTypeEntity.getTypeId());
	}

	public void updateType() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		BookTypeEntity bookTypeEntity = session.get(BookTypeEntity.class, 31L);
		// 此时这个 POJO 对象是 持久态，POJO 对象中已有 OID，也被 Session 管理
		bookTypeEntity.setTypeName("真的放下");
		// session.update(bookTypeEntity); // 不调用更新也可以更新内容
		transaction.commit(); // 提交事务后会对比（快照机制）
		session.close();
	}

	// 一级缓存 (flush，减少访问 DB，提升性能 )
	// 一级缓存就是 session 级别的缓存，两个 session 不能共享一级缓存，因它会伴随 session 的生命周期的创建和消毁
	public void testOneCache() {
		Session session = HibernateUtils.openSession();
		// 第一次查询，找 DB 并打印 SQL 查询语句
		BookTypeEntity bookTypeEntity = session.get(BookTypeEntity.class, 31L);
		System.out.println(bookTypeEntity.getTypeName());
		// 第二次查询，直接找缓存，不找 DB 且不打印 SQL 查询语句
		BookTypeEntity bookTypeEntity2 = session.get(BookTypeEntity.class, 31L);
		System.out.println(bookTypeEntity2.getTypeName());

		// 将一级缓存中的所有对象全部清除
		session.clear();
		// 第三次查询，直接找缓存没记录，找 DB 并打印 SQL 查询语句
		BookTypeEntity bookTypeEntity3 = session.get(BookTypeEntity.class, 31L);
		System.out.println(bookTypeEntity3.getTypeName());
		session.close();
	}

	// HQL 查询
	public void findByHQL() {
		Session session = HibernateUtils.openSession();
		// String hql = "from BookTypeEntity where typeName like :tn"; // 模糊查询
		// 注：条件是 POJO 中的属性名称，不是字段名称
		String hql = "from BookTypeEntity where typeId > ?"; // 条件查询
		Query<BookTypeEntity> query = session.createQuery(hql, BookTypeEntity.class);
		// query.setParameter("tn", "%人工%");
		query.setParameter(0, 29L);
		List<BookTypeEntity> resultList = query.getResultList();
		for (BookTypeEntity bookTypeEntity : resultList) {
			System.out.println(bookTypeEntity.getTypeName() + "\t" + bookTypeEntity.getTypeDesc());
		}
		session.close();
	}

	// HQL 更新和删除
	public void testUpdateHql() {
		Session session = HibernateUtils.openSession();
		Transaction transaction = session.beginTransaction();
		// String hql = "update BookTypeEntity set typeDesc=? where typeId=?";
		String hql = "delete from BookTypeEntity where typeId=?";
		Query query = session.createQuery(hql);
		// query.setParameter(0, "提升自己");
		// query.setParameter(1, 30L);
		query.setParameter(0, 29L);
		query.executeUpdate();
		transaction.commit();
		session.close();
	}

	// HQL 查询某一列
	public void find1() {
		Session session = HibernateUtils.openSession();
		// 如果是一个字段，可以指定这个字段的类型
		Query<String> query = session.createQuery("select typeName from BookTypeEntity", String.class);
		List<String> resultList = query.getResultList();
		for (String s : resultList) {
			System.out.println(s);
		}
		session.close();
	}

	// HQL 查询某几列
	public void find2() {
		Session session = HibernateUtils.openSession();
		// String hql = "select book.bookTypeByTypeId from  BookInfoEntity book where book.bookTypeByTypeId.typeId=1 ";
		// String hql2 = "from BookTypeEntity where typeId=1";
		// 如果查询部分字段
		Query<Object[]> query = session.createQuery("select typeName,typeDesc from BookTypeEntity", Object[].class);
		List<Object[]> resultList = query.getResultList();
		for (Object[] objects : resultList) {
			System.out.println(objects[0] + "\t" + objects[1]);
		}
		session.close();
	}

	// 函数查询
	public void findCount() {
		Session session = HibernateUtils.openSession();
		Query<Long> query = session.createQuery("select count(*) from BookTypeEntity", Long.class);
		Long aLong = query.uniqueResult();
		System.out.println(aLong);
		session.close();
	}

	// 联合查询
	public void find5() {
		Session session = HibernateUtils.openSession();
		// 迫切外链接
		// String hql = "from BookInfoEntity book left join fetch book.bookTypeByTypeId ";
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

	// 本地 sql 查询
	public void findSql() {
		Session session = HibernateUtils.openSession();
		String sql = "select * from book_type";
		NativeQuery<BookTypeEntity> nativeQuery = session.createNativeQuery(sql, BookTypeEntity.class);
		List<BookTypeEntity> list = nativeQuery.list();
		for (BookTypeEntity bookTypeEntity : list) {
			System.out.println(bookTypeEntity.getTypeName()+"\t"+bookTypeEntity.getTypeDesc());
		}
		session.close();
	}
	// 二级缓存，需要引入第三方的缓存工具，如 EhCache 等
	public void testTwoCache() {
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		BookTypeEntity bookTypeEntity = session1.get(BookTypeEntity.class, 30L);
		System.out.println(bookTypeEntity.getTypeName());
		// 关联表
		Collection<BookInfoEntity> bookInfosByTypeId = bookTypeEntity.getBookInfosByTypeId();
		for (BookInfoEntity bookInfoEntity : bookInfosByTypeId) {
			System.out.println(bookInfoEntity.getBookName());
		}
		session1.close();
		System.out.println("============================================================");
		// 第二次查询 走二级缓存，不查 DB
		BookTypeEntity bookTypeEntity2 = session2.get(BookTypeEntity.class, 30L);
		System.out.println(bookTypeEntity2.getTypeName());
		// 关联表
		Collection<BookInfoEntity> bookInfosByTypeId2 = bookTypeEntity2.getBookInfosByTypeId();
		for (BookInfoEntity bookInfoEntity : bookInfosByTypeId2) {
			System.out.println(bookInfoEntity.getBookName());
		}
		session2.close();

	}

	// 二级缓存 query 查询
	public  void testQueyCache(){
		Session session1 = HibernateUtils.openSession();
		Session session2 = HibernateUtils.openSession();
		String hql = "from BookTypeEntity where typeId=:tid";
		Query<BookTypeEntity> query = session1.createQuery(hql, BookTypeEntity.class);
		query.setParameter("tid", 31L);
		// 开启查询缓存
		query.setCacheable(true);
		BookTypeEntity singleResult = query.getSingleResult(); // 获取单条记录
		System.out.println(singleResult.getTypeName());
		session1.close();
		// 第二次查询
		Query<BookTypeEntity> query2 = session2.createQuery(hql, BookTypeEntity.class);
		query2.setParameter("tid", 31L);
		// 开启查询缓存
		query2.setCacheable(true);
		BookTypeEntity singleResult2 = query2.getSingleResult(); // 获取单条记录
		System.out.println(singleResult2.getTypeName());
		session2.close();
	}

	public static void main(String[] args) {
		TypeDAO typeDAO = new TypeDAO();
		// typeDAO.addType();
		// typeDAO.updateType();
		// typeDAO.testOneCache();
		// typeDAO.findByHQL();
		// typeDAO.testUpdateHql();
		// typeDAO.find1();
		// typeDAO.find2();
		// typeDAO.findCount();
		// typeDAO.find5();
		// typeDAO.findSql();
		// typeDAO.testTwoCache();
		typeDAO.testQueyCache();
	}

}
