package com.qianfeng.service;

import com.qianfeng.dao.BlogDAO;
import com.qianfeng.entity.Blog;

import java.util.List;

public class BlogService {
    public List<Blog> findAll(){
        return new BlogDAO().findAll();
    }
}
