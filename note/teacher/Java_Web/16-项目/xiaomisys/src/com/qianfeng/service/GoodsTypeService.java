package com.qianfeng.service;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.GoodsType;
import com.qianfeng.vo.VGoodsType;

public interface GoodsTypeService {

	public void addType(GoodsType type);
	
	public List<GoodsType> findTypeByLevel(Integer level);
	
	public List<VGoodsType> findAllType();
	
	public GoodsType findTypeById(Integer id);
	
	public List<VGoodsType> search(Map<String, Object> infos);
}
