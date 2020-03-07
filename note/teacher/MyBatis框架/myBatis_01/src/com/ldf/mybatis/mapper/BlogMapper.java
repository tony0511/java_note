package com.ldf.mybatis.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized.Parameter;

import com.ldf.mybatis.pojo.Blog;

public interface BlogMapper {
  
    // ***** CRUD *****
  
    Blog selectBlog(Integer id);
    
    List<Blog> selectBlogList(String name);
    
//    List<Blog> selectBlogByPage(int offset, int pageSize );
//    List<Blog> selectBlogByPage(@Param(value="offset") int offset, @Param(value="pageSize") int pageSize);
    List<Blog> selectBlogByPage(Map<String, Object> map);
    
    int insertBlog(Blog blog);
    int insertBlogMysql(Blog blog);
    int insertBlogOracle(Blog blog);
    
    int upadteBlog(Blog blog);
    
    int deleteBlogById(Integer id);
    
    // ***** 动态sql *****
    
    List<Blog> selectBlogListIf(String name);
    
    List<Blog> selectBlogListChoose(Blog blog);

    int upadteBlogSet(Blog blog);
    
    int deleteBlogByIds(List<Integer> ids);

    List<Blog> selectBlogListNested();
    
}
