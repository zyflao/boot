package com.zyf.dao;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zyf.dao.api.KillerMapper;

/**
 * spring junit整合。 加载spring Ioc容器 springtest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class KillerMapTest {

	Logger log = Logger.getLogger(KillerMapTest.class);
	// 注入Dao
	@Resource
	private KillerMapper killerMapper;

	@Test
	public void selectByPrimaryKeyTest() {
		Long id = 1L;
		Killer k = killerMapper.selectByPrimaryKey(id);
		System.out.println(k.toString());
	}

	@Test
	public void insertSelectiveTest() {

		Long id = 2L;
		String userPhone = "13261251343";
		Byte b = 1;
		Killer k = new Killer();
		k.setSeckillId(id);
		k.setState(b);
		k.setUserPhone(userPhone);
		log.info("================" + killerMapper.insert(k));

	}
}
