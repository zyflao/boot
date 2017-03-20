package com.zyf.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Example {
	Logger log = Logger.getLogger(Example.class);

	@Value("${encryptionKey}")
	private String a;

	@RequestMapping(value = "/")
	String home() {
		return "Hello World!" + a;
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		log.info(myName);
		return "Hello " + myName + "!!!";
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello(
			@RequestParam(value = "name", required = false, defaultValue = "default1") String myName) {
		log.info(myName);
		return "Hello " + myName + "!!!";
	}
}