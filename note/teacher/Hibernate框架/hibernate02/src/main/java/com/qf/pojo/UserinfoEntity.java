package com.qf.pojo;

/**
 * Thanks for Everything.
 */
public class UserinfoEntity {
	private Long uid;
	private String userName;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		UserinfoEntity that = (UserinfoEntity) o;

		if (uid != null ? !uid.equals(that.uid) : that.uid != null) return false;
		if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
		if (userPass != null ? !userPass.equals(that.userPass) : that.userPass != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = uid != null ? uid.hashCode() : 0;
		result = 31 * result + (userName != null ? userName.hashCode() : 0);
		result = 31 * result + (userPass != null ? userPass.hashCode() : 0);
		return result;
	}
}
