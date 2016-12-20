package com.zyf.web;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
	Logger log = Logger.getLogger(Example.class);

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		log.info(myName);
		return "Hello " + myName + "!!!";
	}
}