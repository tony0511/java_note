package com.qianfeng.dao;

import java.util.List;

import com.qianfeng.entity.DinnerTable;

public interface DinnerTableDao {

	public void add(DinnerTable dt);
	
	public void deleteById(Integer id);
	
	public List<DinnerTable> findAll();
}
