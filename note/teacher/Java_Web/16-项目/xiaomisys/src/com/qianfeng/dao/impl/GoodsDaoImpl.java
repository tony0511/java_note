package com.qianfeng.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.qianfeng.dao.GoodsDao;
import com.qianfeng.entity.Goods;
import com.qianfeng.utils.JDBCUtils;

public class GoodsDaoImpl implements GoodsDao{

	@Override
	public void add(Goods goods) {
		// TODO Auto-generated method stub
		String sql = "insert into t_goods(goodsname,price,deployDate,score,comment,typeId,imgPath) value(?,?,?,?,?,?,?)";
		QueryRunner qr = JDBCUtils.getQueryRunner();
		
		Object[] params = new Object[]{
				goods.getGoodsName(),
				goods.getPrice(),
				goods.getDeployDate(),
				goods.getScore(),
				goods.getComment(),
				goods.getTypeId(),
				goods.getImgPath()
		};
		
		try {
			qr.update(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
