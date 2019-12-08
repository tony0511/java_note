package com.qianfeng.dao;

import java.util.List;
import java.util.Map;

import com.qianfeng.entity.GoodsType;
import com.qianfeng.vo.VGoodsType;

public interface TypeDao {

	// 添加二级分类
	public void add(GoodsType type);
	
	// 根据分类等级获取数据
	public List<GoodsType> findAllByLevel(Integer level);
	
	// 查询所有的分类数据
	public List<VGoodsType> findAll();
	
	// 根据id查询商品分类
	public GoodsType findById(Integer id);
	
	// 根据传来的条件进行动态查询
	public List<VGoodsType> findByCondition(Map<String, Object> infos);
}
