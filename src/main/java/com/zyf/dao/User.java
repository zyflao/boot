package com.zyf.dao;

import java.util.Date;

/**
 * @author yunfeng.zang CreateTime 2017/4/24 17:02
 */
public class User {

	private Long id;

	private String name;

	private Date createDate;

	private String deparment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDeparment() {
		return deparment;
	}

	public void setDeparment(String deparment) {
		this.deparment = deparment;
	}
}
