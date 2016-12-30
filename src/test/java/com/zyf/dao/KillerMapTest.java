package com.zyf.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyf.dao.api.KillerMapper;

/**
 * spring junit整合。 加载spring Ioc容器 springtest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class KillerMapTest {
	// 注入Dao
	@Resource
	private KillerMapper killerMapper;

	@Test
	public void selectByPrimaryKeyTest() {
		Long id = 1L;
		Killer k = killerMapper.selectByPrimaryKey(id);
		System.out.println(k.toString());
	}
}
