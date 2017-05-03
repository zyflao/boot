package com.zyf.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao.xml")
public class SeckillServiceTest {
	@Resource
	SeckillService seckillService;

	@Test
	public void query() {
		System.out.println(seckillService.query());

	}
}
