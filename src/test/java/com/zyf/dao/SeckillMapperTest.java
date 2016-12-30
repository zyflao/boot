package com.zyf.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyf.dao.api.SeckillMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class SeckillMapperTest {

	@Resource
	SeckillMapper seckillMapper;

	@Test
	public void selectAll() {
		List<Seckill> list = seckillMapper.selectAll();
		System.out.println(list.toString());
	}

}
