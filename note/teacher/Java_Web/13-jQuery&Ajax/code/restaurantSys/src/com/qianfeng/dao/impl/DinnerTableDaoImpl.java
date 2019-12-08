package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.dao.DinnerTableDao;
import com.qianfeng.entity.DinnerTable;
import com.qianfeng.utils.JDBCUtils;

public class DinnerTableDaoImpl implements DinnerTableDao{

	@Override
	public void add(DinnerTable dt) {
		// TODO Auto-generated method stub
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "insert into dinnertable(name) values(?)";
		try {
			qr.update(sql, dt.getName());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<DinnerTable> findAll() {
		// TODO Auto-generated method stub
		QueryRunner qr = JDBCUtils.getQueryRunner();
		String sql = "select * from dinnertable";
		List<DinnerTable> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(DinnerTable.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
