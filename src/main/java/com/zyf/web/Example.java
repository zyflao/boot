package com.zyf.web;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.zyf.dao.User;

@RestController
@EnableAutoConfiguration
public class Example {
	Logger log = Logger.getLogger(Example.class);

	@Value("${encryptionKey}")
	private String a;

	@RequestMapping(value = "/")
	String home() {
		return "Hello World:" + a;
	}

	@RequestMapping("/hello/{myName}")
	String index(@PathVariable String myName) {
		log.info(myName);
		return "Hello:" + myName;
	}

	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	String hello(
			@RequestParam(value = "name", required = false, defaultValue = "default1") String myName) {
		log.info(myName);
		return "Hello " + myName;
	}

	@RequestMapping("/greeting")
	public ModelAndView greeting(
			@RequestParam(value = "name", required = false, defaultValue = "zyf") String name,
			Model model) {
		model.addAttribute("name", name);
		return new ModelAndView("regreeting");
	}

	@RequestMapping("/admin")
	public ModelAndView admin(
			@RequestParam(value = "name", required = false, defaultValue = "zyf") String name,
			Model model) {
		User u = new User();
		u.setName("nn");
		model.addAttribute("message", name);
		model.addAttribute("user", u);
		return new ModelAndView("admin");
	}
}