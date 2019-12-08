package com.qianfeng.entity;

public class Food {
	private Integer id;
	private String foodName;
	private Double price;
	private Double vprice;
	private String comment;
	private Integer typeId;
	
	// 一个菜品属于一个菜系
	//private FoodType foodType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getVprice() {
		return vprice;
	}
	public void setVprice(Double vprice) {
		this.vprice = vprice;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	
}
