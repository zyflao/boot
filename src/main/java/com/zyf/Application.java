package com.zyf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.zyf.Interceptor.ControllerInterceptor;
import com.zyf.Interceptor.LogHandlerInterceptor;

@SpringBootApplication
@ImportResource(locations = { "classpath:spring/spring-dao.xml" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}

@Configuration
class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogHandlerInterceptor()).addPathPatterns(
				"/**");
		registry.addInterceptor(new ControllerInterceptor()).addPathPatterns(
				"/**");
		super.addInterceptors(registry);
	}
}
