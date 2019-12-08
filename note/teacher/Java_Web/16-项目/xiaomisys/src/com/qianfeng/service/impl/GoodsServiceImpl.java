package com.qianfeng.service.impl;

import com.qianfeng.dao.GoodsDao;
import com.qianfeng.dao.impl.GoodsDaoImpl;
import com.qianfeng.entity.Goods;
import com.qianfeng.service.GoodsService;

public class GoodsServiceImpl implements GoodsService{

	private GoodsDao goodsDao = new GoodsDaoImpl();
	@Override
	public void addGoods(Goods goods) {
		// TODO Auto-generated method stub
		goodsDao.add(goods);
	}

}
