package com.qianfeng.blog.service;

import java.util.List;

import com.qianfeng.blog.dao.BlogDAO;
import com.qianfeng.blog.entity.Blog;

public class BlogService {
	public List<Blog> findAll(){
		return new BlogDAO().findAll();
	}
}
