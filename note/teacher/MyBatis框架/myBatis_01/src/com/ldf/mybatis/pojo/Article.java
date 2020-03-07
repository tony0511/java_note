package com.ldf.mybatis.pojo;

import java.io.Serializable;

public class Article implements Serializable {
  
  private static final long serialVersionUID = 1L;
  
  Integer id;
  Integer blogId;
  String content;
  Blog blog;
  
  public Article() {
    super();
  }
  
  public Article(Integer blogId, String content) {
    super();
    this.blogId = blogId;
    this.content = content;
  }

  public Article(Integer id, Integer blogId, String content) {
    super();
    this.id = id;
    this.blogId = blogId;
    this.content = content;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBlogId() {
    return blogId;
  }

  public void setBlogId(Integer blogId) {
    this.blogId = blogId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  @Override
  public String toString() {
    return "Article [id=" + id + ", blogId=" + blogId + ", content=" + content + "]\n";
  }
  
}
