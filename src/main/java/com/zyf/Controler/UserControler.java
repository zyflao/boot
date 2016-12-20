package com.zyf.Controler;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class UserControler {

	@RequestMapping("/User")
	@ResponseBody
	String login() {
		return "zyf";
	}

}
