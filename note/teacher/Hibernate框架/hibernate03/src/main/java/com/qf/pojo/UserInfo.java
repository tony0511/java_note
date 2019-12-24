package com.qf.pojo;

import javax.persistence.*;

/**
 * Thanks for Everything.
 */
@Entity
@Table(name = "userinfo")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uid;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "user_pass")
	private String userPass;

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
}
