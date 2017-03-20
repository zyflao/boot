package com.zyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyf.dao.Killer;
import com.zyf.dao.Seckill;
import com.zyf.dao.api.KillerMapper;
import com.zyf.dao.api.SeckillMapper;

@Service
public class SeckillService extends BaseService {

	@Autowired
	SeckillMapper seckillMapper;
	@Autowired
	KillerMapper killerMapper;

	public List<Seckill> query() {
		return seckillMapper.selectAll();

	}

	void goodskill(String userPhone, Long seckillId) {

		Byte b = 1;
		Killer k = new Killer();
		k.setSeckillId(seckillId);
		k.setState(b);
		k.setUserPhone(userPhone);

		Seckill seckill = new Seckill();
		seckill.setSeckillId(seckillId);

		seckillMapper.updateByPrimaryKey(seckill);

	}
}
