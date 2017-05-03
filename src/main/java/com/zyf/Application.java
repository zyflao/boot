package com.zyf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zyf.Interceptor.ControllerInterceptor;
import com.zyf.Interceptor.LogHandlerInterceptor;

@SpringBootApplication
@ImportResource(locations = { "classpath:spring/spring-dao.xml",
		"classpath:spring/spring-thymeleaf.xml" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

/**
 * @author yunfeng.zang
 * @createTime 2017年1月11日下午5:01:48 跨域问题 springboot配置
 */
@Configuration
class MyWebAppConfigurer extends WebMvcConfigurerAdapter {
	/**
	 * 添加静态资源路径默认src/main/resource下
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/template/**").addResourceLocations(
				"classpath:/template/");
		super.addResourceHandlers(registry);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/jquery/**")
				// .allowedOrigins("http://domain2.com")
				.allowedMethods("POST", "GET")
				.allowedHeaders("header", "sessionId", "passportId")
				.maxAge(3600);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogHandlerInterceptor()).addPathPatterns(
				"/**");
		registry.addInterceptor(new ControllerInterceptor()).addPathPatterns(
				"/**");
		super.addInterceptors(registry);
	}
}
