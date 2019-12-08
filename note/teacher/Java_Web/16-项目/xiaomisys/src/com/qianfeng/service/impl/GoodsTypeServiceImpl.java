package com.qianfeng.service.impl;

import java.util.List;
import java.util.Map;

import com.qianfeng.dao.TypeDao;
import com.qianfeng.dao.impl.TypeDaoImpl;
import com.qianfeng.entity.GoodsType;
import com.qianfeng.service.GoodsTypeService;
import com.qianfeng.vo.VGoodsType;

public class GoodsTypeServiceImpl implements GoodsTypeService{

	private TypeDao typeDao = new TypeDaoImpl();
	
	@Override
	public void addType(GoodsType type) {
		// TODO Auto-generated method stub
		if(type == null){
			throw new RuntimeException("分类信息不能为空");
		}
		
		try {
			typeDao.add(type);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public List<GoodsType> findTypeByLevel(Integer level) {
		// TODO Auto-generated method stub
		
		try {
			List<GoodsType> list = typeDao.findAllByLevel(level);
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
		
	}
	
	@Override
	public List<VGoodsType> findAllType() {
		// TODO Auto-generated method stub
		return typeDao.findAll();
	}
	
	@Override
	public GoodsType findTypeById(Integer id) {
		// TODO Auto-generated method stub
		
		return typeDao.findById(id);
	}
	
	@Override
	public List<VGoodsType> search(Map<String, Object> infos) {
		// TODO Auto-generated method stub
		return typeDao.findByCondition(infos);
	}


}
