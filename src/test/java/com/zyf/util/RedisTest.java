/*
 * package com.zyf.util;
 * 
 * import org.junit.Assert; import org.junit.Test; import
 * org.junit.runner.RunWith; import
 * org.springframework.beans.factory.annotation.Value; import
 * org.springframework.test.context.ContextConfiguration; import
 * org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 * 
 * @RunWith(SpringJUnit4ClassRunner.class)
 * 
 * @ContextConfiguration("classpath:application.yml") public class RedisTest {
 * 
 * @Value("${encryptionKey}") private String v;
 * 
 * public static void main(String[] args) { RedisTest redisTest = new
 * RedisTest(); System.out.println(redisTest.v); }
 * 
 * @Test public void test() throws Exception { Assert.assertEquals(v, 1);
 * System.out.println(v); // 保存字符串 //
 * stringRedisTemplate.opsForValue().set("aaa", "111"); //
 * Assert.assertEquals("111", // stringRedisTemplate.opsForValue().get("aaa"));
 * 
 * }
 * 
 * }
 */