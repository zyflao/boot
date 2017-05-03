package com.zyf.quartz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

public class MyTestServiceImpl implements IMyTestService {
	// 每5秒执行一次
	public void myTest() {
		System.out.println("进入测试");
	}

	public static void main(String[] args) {
		args = new String[] { "classpath:spring/spring-task.xml" };
		ApplicationContext actx = new ClassPathXmlApplicationContext(args);
	}
}