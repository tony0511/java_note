package com.qfedu.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import com.qfedu.springmvc.pojo.User;

public class UserConverter implements Converter<String, User>{
    /**
     * 将字符串转换成日期格式
     */
    @Override
    public User convert(String source) {
    	System.out.println(source);
    	
    	System.out.println("user格式转换器");
    	
    	if(source != null) {
    		String[] split = source.split("|");
        	if(split != null && split.length == 3) {
        		String username = split[0];
        		Integer age = Integer.parseInt(split[1]);
        		String email = split[2];
        		String birday = split[3];
        		
        		User user = new User();
        		user.setUsername(username);
        		user.setAge(age);
        		user.setEmail(email);
        		//user.setBirthday(birthday);
        		
        		return user;
        	}
    	}
    	return null;
    }
}
