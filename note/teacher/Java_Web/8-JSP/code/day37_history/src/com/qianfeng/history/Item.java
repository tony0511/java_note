package com.qianfeng.history;

public class Item {

	private Integer id;
	private String name;
	private Double price;
	private String comment;
	
	public Item(){}
	
	public Item(Integer id, String name, Double price, String comment){
		this.id = id;
		this.name = name;
		this.price = price;
		this.comment = comment;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
