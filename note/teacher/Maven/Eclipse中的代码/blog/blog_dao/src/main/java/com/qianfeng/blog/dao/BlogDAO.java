package com.qianfeng.blog.dao;

import java.util.ArrayList;
import java.util.List;

import com.qianfeng.blog.entity.Blog;

public class BlogDAO {
	// 模拟从数据库中取数据
	public List<Blog> findAll(){
		List<Blog> list = new ArrayList<Blog>();
		for (int i = 0; i < 5; i++) {
			Blog blog = new Blog();
			blog.setId(i + 1);
			blog.setTitle("博客标题" + (i+1));
			blog.setContent("内容" + (i+1));
			list.add(blog);
		}
		return list;
	}
}
