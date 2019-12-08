package com.qianfeng.service;

import java.util.List;

import com.qianfeng.entity.DinnerTable;

public interface DinnerTableService {

	public List<DinnerTable> findAllTable();
	
	public void addTable(DinnerTable dt);
	
	public void delTableById(Integer id);
	
	public void orderTable(Integer state);
}
