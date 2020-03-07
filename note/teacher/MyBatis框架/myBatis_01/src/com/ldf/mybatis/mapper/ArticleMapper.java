package com.ldf.mybatis.mapper;

import java.util.List;

import com.ldf.mybatis.pojo.Article;

public interface ArticleMapper {
  
    // ***** CRUD *****
  
  Article selectArticleById(Integer id);
  
  List<Article> selectArticleByBlogId(Integer blogId);
    
}
