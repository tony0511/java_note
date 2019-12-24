package com.qf.pojo;

import javax.persistence.*;

/**
 * Thanks for Everything.
 */
@Entity
@Table(name = "my_computer")
public class MyComputer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long comId;
	@Column(name = "com_name")
	private String comName;
	@Column(name = "com_desc")
	private String comDesc;

	public Long getComId() {
		return comId;
	}

	public void setComId(Long comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComDesc() {
		return comDesc;
	}

	public void setComDesc(String comDesc) {
		this.comDesc = comDesc;
	}
}
