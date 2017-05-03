package com.zyf.web;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author yunfeng.zang
 * @createTime 2017年5月1日下午6:10:23 测试Example
 * 
 *             •RunWith(SpringJUnit4ClassRunner.class): 表示使用Spring Test组件进行单元测试;
 * 
 *             •WebAppConfiguration:
 *             使用这个Annotate会在跑单元测试的时候真实的启一个web服务，然后开始调用Controller的Rest
 *             API，待单元测试跑完之后再将web服务停掉;
 * 
 *             •ContextConfiguration: 指定Bean的配置文件信息，可以有多种方式
 *             ，这个例子使用的是文件路径形式，如果有多个配置文件，可以将括号中的信息配置为一个字符串数组来表示; //
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
@WebAppConfiguration
@Rollback(true)
public class ExampleTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();

	}

	@Value("${encryptionKey}")
	private String a;

	@Test
	public void testHome() throws Exception {

		mockMvc.perform(
				get("/").accept(
						MediaType
								.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("application/json;charset=UTF-8"))
				// .andExpect(content().json("{'foo':'bar'}"));
				.andExpect(content().string("Hello World:zyf"));
	}

	public static String getRandomString(int length) { // length表示生成字符串的长度
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	@Test
	public void testIndex() throws Exception {
		String name = getRandomString(3);
		mockMvc.perform(
				get("/hello/" + name)
						.accept(MediaType
								.parseMediaType("application/json;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("application/json;charset=UTF-8"))
				// .andExpect(content().json("{'foo':'bar'}"));
				.andExpect(content().string("Hello:" + name));
	}

	@Test
	public void testHello() {
		fail("Not yet implemented");
	}

	@Test
	public void testGreeting() throws Exception {
		mockMvc.perform(
				get("/greeting").accept(
						MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk());
	}

	@Test
	public void testAdmin() {
		fail("Not yet implemented");
	}

}
