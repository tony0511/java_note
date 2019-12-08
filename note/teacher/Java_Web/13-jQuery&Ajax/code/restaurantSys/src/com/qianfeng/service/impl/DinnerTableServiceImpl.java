package com.qianfeng.service.impl;

import java.util.List;

import com.qianfeng.dao.DinnerTableDao;
import com.qianfeng.dao.impl.DinnerTableDaoImpl;
import com.qianfeng.entity.DinnerTable;
import com.qianfeng.service.DinnerTableService;

public class DinnerTableServiceImpl implements DinnerTableService {
	private DinnerTableDao tableDao = new DinnerTableDaoImpl();
	
	@Override
	public List<DinnerTable> findAllTable() {
		// TODO Auto-generated method stub
		
		return tableDao.findAll();
	}

	@Override
	public void addTable(DinnerTable dt) {
		// TODO Auto-generated method stub
		tableDao.add(dt);
	}

	@Override
	public void delTableById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void orderTable(Integer state) {
		// TODO Auto-generated method stub
		
	}

}
