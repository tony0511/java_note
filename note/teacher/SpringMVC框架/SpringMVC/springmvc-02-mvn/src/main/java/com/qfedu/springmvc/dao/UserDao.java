package com.qfedu.springmvc.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.qfedu.springmvc.pojo.Address;
import com.qfedu.springmvc.pojo.User;

@Repository
public class UserDao {

	private static Map<Integer, User> users = null;
	
	//@Autowired
	//private DepartmentDao departmentDao;
	
	static{
		users = new HashMap<Integer, User>();

		users.put(1001, new User(1001, "Helen1", "123", "123@qq.com", 12, new Address(1, "黑龙江", "哈尔滨")));
		users.put(1002, new User(1002, "Helen2", "123", "123@qq.com", 12, new Address(1, "黑龙江", "哈尔滨")));
		users.put(1003, new User(1003, "Helen3", "123", "123@qq.com", 12, new Address(1, "黑龙江", "哈尔滨")));
	}
	
	private static Integer initId = 1004;
	
	public void save(User user){
		if(user.getId() == null){
			user.setId(initId++);
		}
		users.put(user.getId(), user);
	}
	
	public Collection<User> getAll(){
		return users.values();
	}
	
	public User get(Integer id){
		return users.get(id);
	}
	
	public void delete(Integer id){
		users.remove(id);
	}
}
