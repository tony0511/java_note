package com.qianfeng.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.qianfeng.dao.TypeDao;
import com.qianfeng.entity.GoodsType;
import com.qianfeng.utils.JDBCUtils;
import com.qianfeng.vo.VGoodsType;

public class TypeDaoImpl implements TypeDao{

	@Override
	public void add(GoodsType type) {
		// TODO Auto-generated method stub
		String sql = "insert into t_goodstype(typename, level, pid) values(?,?,?)";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		try {
			qr.update(sql, type.getTypeName(), 2, type.getPid());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
		
	}

	@Override
	public List<GoodsType> findAllByLevel(Integer level) {
		// TODO Auto-generated method stub
		String sql = "select * from t_goodstype where level=?";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		List<GoodsType> types = null;
		try {
			types = qr.query(sql, new BeanListHandler<>(GoodsType.class), level);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return types;
	}

	@Override
	public List<VGoodsType> findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT c.id,c.typename,c.`level`,p.typename parentName from t_goodstype c left join t_goodstype p on c.pid=p.id";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		List<VGoodsType> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<>(VGoodsType.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public GoodsType findById(Integer id) {
		// TODO Auto-generated method stub
		String sql = "select * from t_goodstype where id=?";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		GoodsType type = null;
		try {
			type = qr.query(sql, new BeanHandler<>(GoodsType.class), id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return type;
	}
	
	@Override
	public List<VGoodsType> findByCondition(Map<String, Object> infos) {
		// TODO Auto-generated method stub
		//String sql = "select * from t_goodstype where 1=1";
		String sql = "SELECT c.id,c.typename,c.`level`,p.typename parentName from t_goodstype c left join t_goodstype p on c.pid=p.id where 1=1";
		Object[] params = null;
		if(infos != null){
			params = new Object[infos.size()];
			int i = 0;
			for (String key : infos.keySet()) {
				if(key.equals("level")){
					sql += " and c.`level`=?";	
				}else if(key.equals("typename")){
					sql += " and c.typename like ?";
				}
				params[i] = infos.get(key);
				i++;
			}
		}
		System.out.println(sql);
		QueryRunner qr = JDBCUtils.getQueryRunner();
		List<VGoodsType> list= null;
		try {
			list = qr.query(sql, new BeanListHandler<>(VGoodsType.class), params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
