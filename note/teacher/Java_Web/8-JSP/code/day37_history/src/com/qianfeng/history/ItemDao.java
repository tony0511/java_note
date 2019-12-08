package com.qianfeng.history;

import java.util.ArrayList;
import java.util.List;

public class ItemDao {

	private static List<Item> list = null;
	
	static{
		list = new ArrayList<Item>();
		for(int i = 0; i < 10; i++){
			Item item = new Item(100 + i, "奶粉" + i, 400.0, "没有三聚氰胺");
			list.add(item);
		}
	}
	
	public List<Item> findAll(){
		return list;
	}
	
	public Item findById(Integer id){
		for (Item item : list) {
			if(item.getId() == id){
				return item;
			}
		}
		return null;
	}
}
