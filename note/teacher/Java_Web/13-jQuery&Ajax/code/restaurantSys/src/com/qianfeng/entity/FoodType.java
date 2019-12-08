package com.qianfeng.entity;

public class FoodType {

	private Integer id;
	private String typeName;
	
	// 一个菜系下有多个菜品
	//private List<Food> foodList;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	
}
