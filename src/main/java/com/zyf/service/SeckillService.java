package com.zyf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyf.dao.Seckill;
import com.zyf.dao.api.SeckillMapper;
import com.zyf.web.BaseService;

@Service
public class SeckillService extends BaseService {

	@Autowired
	SeckillMapper seckillMapper;

	public List<Seckill> query() {
		return seckillMapper.selectAll();

	}
}
