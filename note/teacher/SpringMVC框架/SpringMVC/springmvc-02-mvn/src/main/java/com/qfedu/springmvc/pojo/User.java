package com.qfedu.springmvc.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer age;
	private Address address;
	
	//@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	public User() {
		super();
	}
	
	public User(Integer id, String username, String password, String email, Integer age, Address address) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", age="
				+ age + ", address=" + address + ", birthday=" + birthday + "]";
	}

}
