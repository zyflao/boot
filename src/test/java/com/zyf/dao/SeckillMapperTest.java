package com.zyf.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyf.dao.api.SeckillMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillMapperTest {
	Logger log = Logger.getLogger("SeckillMapperTest");
	@Resource
	SeckillMapper seckillMapper;

	@Test
	public void selectAll() {
		List<Seckill> list = seckillMapper.selectAll();
		System.out.println(list.toString());
	}

	@Test
	public void updateNum() {
		Seckill seckill = new Seckill();
		seckill.setSeckillId(2L);
		int i = seckillMapper.updateByPrimaryKey(seckill);
		log.info("==========" + i);
	}
}
