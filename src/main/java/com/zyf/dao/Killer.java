package com.zyf.dao;

import org.springframework.stereotype.Component;

@Component
public class Killer {

	private Long id;

	private Long seckillId;

	private String userPhone;

	private Byte state;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(Long seckillId) {
		this.seckillId = seckillId;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public Byte getState() {
		return state;
	}

	public void setState(Byte state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Killer [id=" + id + ", seckillId=" + seckillId + ", userPhone="
				+ userPhone + ", state=" + state + "]";
	}

}