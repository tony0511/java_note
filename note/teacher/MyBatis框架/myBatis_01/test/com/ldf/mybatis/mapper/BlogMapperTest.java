package com.ldf.mybatis.mapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.ldf.mybatis.pojo.Blog;
import com.ldf.mybatis.utils.MyBatisUtil;

public class BlogMapperTest {
  
  // ***** CRUD *****
  @Test
  public void testSelectBlogNoInterface() {
      SqlSession session = MyBatisUtil.getSqlSession();
      
      Blog blog = (Blog) session.selectOne("com.ldf.mybatis.mapper.BlogMapper.selectBlog", 12);
      
      session.close();
      
      System.out.println(blog);
  }
  
  @Test
  public void testSelectBlog() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    Blog blog = blogMapper.selectBlog(12);
    
    session.close();
    
    System.out.println(blog);
    
  }
  
  @Test
  public void testSelectBlogList() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    List<Blog> blogList = blogMapper.selectBlogList("'%马%'");
//    List<Blog> blogList = blogMapper.selectBlogList("%马%");
//    List<Blog> blogList = blogMapper.selectBlogList("马");
    
    session.close();
    
//    System.out.println(blogList);
    
  }
  
  @Test
  public void testSelectBlogByPage() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
//    List<Blog> blogList = blogMapper.selectBlogByPage(2, 2);
    Map<String, Object> map = new HashMap<String, Object>();
    map.put("offset", 2);
    map.put("pageSize", 2);
    List<Blog> blogList = blogMapper.selectBlogByPage(map);
    session.close();
    
    System.out.println(blogList);
    
  }
  
  @Test
  public void testInsertBlog() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
//    Blog blog = new Blog(15, "啦啦", 234);
//    int count = blogMapper.insertBlog(blog);
    Blog blog = new Blog("啦啦乐乐", 222);
    int count = blogMapper.insertBlog(blog);
//    int count = blogMapper.insertBlogMysql(blog);
//    int count = blogMapper.insertBlogOracle(blog);
    
    session.commit();
    session.close();
    
    System.out.println(count);
    System.out.println(blog);
    
  }
  
  @Test
  public void testUpadteBlog() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    
//    Blog blog = new Blog(10, "张三三", 1);
    Blog blog = blogMapper.selectBlog(10);
    blog.setName("张三三三");
    int count = blogMapper.upadteBlog(blog);
    
    session.commit();
    session.close();
    
    System.out.println(count);
    System.out.println(blog);
    
  }
  
  @Test
  public void testDeleteBlogById() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);

    int count = blogMapper.deleteBlogById(16);
    
    session.commit();
    session.close();
    
    System.out.println(count);
    
  }
  
  // ***** 动态sql *****

  @Test
  public void testSelectBlogListIf() {
      SqlSession session = MyBatisUtil.getSqlSession();
      
      BlogMapper blogMapper = session.getMapper(BlogMapper.class);
//      List<Blog> blogList = blogMapper.selectBlogListByName("马");
      List<Blog> blogList = blogMapper.selectBlogListIf(null);
      
      session.close();
      
      System.out.println(blogList);
  }
  
  @Test
  public void testSelectBlogListChoose() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    Blog blog = new Blog();
//    blog.setId(13);
    blog.setName("%六%");
    List<Blog> blogList = blogMapper.selectBlogListChoose(blog);
    
    session.close();
    
    System.out.println(blogList);
    
  }
  
  @Test
  public void testUpadteBlogSet() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    
    Blog blog = new Blog();
    blog.setId(10);
    blog.setName("张三");
    int count = blogMapper.upadteBlogSet(blog);
    
    session.commit();
    session.close();
    
    System.out.println(count);
    System.out.println(blog);
    
  }
  
  @Test
  public void testDeleteBlogByIds() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    
    List<Integer> ids = Arrays.asList(18, 19);
    int count = blogMapper.deleteBlogByIds(ids);
    
    session.commit();
    session.close();
    
    System.out.println(count);
    
  }
  
  // ***** 性能问题 *****
  
  /* 一级缓存
   * 是session级别的缓存，一级缓存默认存在。
   * */
  @Test
  public void testSelectBlogCacheLevelOne1() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    
    Blog blog1 = blogMapper.selectBlog(12);
    System.out.println("结果已查询");
    
    // 1. 当在同一个session范围内执行查询的时候，如果执行相同的查询，那么第二次查询会从缓存中获取数据
//    Blog blog2 = blogMapper.selectBlog(12);
//    System.out.println("结果已查询，从缓存中获取数据");
    
    // 2. 如果两次查询之间有增删改操作,sqlsession缓存区会被自动清空，说明下一次查询会重新执行sql语句
    blog1.setDeptno(35);
    blogMapper.upadteBlog(blog1);
    System.out.println("刷新缓存");
    
    Blog blog2 = blogMapper.selectBlog(12);
    System.out.println("重新执行查询");

    session.commit();
    session.close();
    
    System.out.println(blog1);
    System.out.println(blog2);
    
  }
  
  // ***** 性能问题 *****
  
  /* 二级缓存
   * 默认不开启。如果在不同的session范围内，执行相同的数据查询，那么每次查询将会执行独立的数据库检索过程。
   * 开启二级缓存：
   *    1. 在mapper文件中设置 <cache />
   *    2. 在实体类中实现序列化接口
   * */
  @Test
  public void testSelectBlogCacheLevelOne2() {
    
    SqlSession session1 = MyBatisUtil.getSqlSession();
    BlogMapper blogMapper1 = session1.getMapper(BlogMapper.class);
    
    Blog blog1 = blogMapper1.selectBlog(12);
    System.out.println("session1 结果已查询");
    
//    session1.close();
//    
//    SqlSession session2 = MyBatisUtil.getSqlSession();
//    BlogMapper blogMapper2 = session2.getMapper(BlogMapper.class);
//    
//    Blog blog2 = blogMapper2.selectBlog(12);
//    System.out.println("session2 结果已查询：重新查询数据库，命中率为0.5");

    blog1.setDeptno(36);
    blogMapper1.upadteBlog(blog1);
    System.out.println("刷新二级缓存");
    
    session1.commit();
    session1.close();
    
    SqlSession session2 = MyBatisUtil.getSqlSession();
    BlogMapper blogMapper2 = session2.getMapper(BlogMapper.class);
    
    Blog blog2 = blogMapper2.selectBlog(12);
    System.out.println("session2 结果已查询：缓存被刷新，所以重新查询");
    
    session2.close();
    
    System.out.println(blog1);
    System.out.println(blog2);
    
  }
  
  // 嵌套结果
  @Test
  public void testSelectBlogListNested() {
    SqlSession session = MyBatisUtil.getSqlSession();
    
    BlogMapper blogMapper = session.getMapper(BlogMapper.class);
    List<Blog> blogList = blogMapper.selectBlogListNested();
    
    session.close();
    
    System.out.println(blogList);
    
  }
  
}
