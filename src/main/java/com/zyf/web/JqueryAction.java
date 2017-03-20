package com.zyf.web;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/jquery")
public class JqueryAction {
	Logger log = Logger.getLogger(JqueryAction.class);

	@RequestMapping("/login")
	String login(
			@RequestParam(value = "name", required = true, defaultValue = "") String myName,
			@RequestHeader HttpHeaders headers) {
		log.info("进入:" + myName + "headers:" + headers.toString());
		String passportId = headers.get("passportId").get(0);
		String sessionId = headers.get("sessionId").get(0);

		Map<String, String> map = new HashMap<String, String>();
		map.put("passportId", passportId);
		map.put("sessionId", sessionId);

		return OpenResult.ok().add("data", map).buildJsonNew();

	}

	@RequestMapping("/verify")
	String verify(
			@RequestParam(value = "name", required = true, defaultValue = "") String myName,
			@RequestHeader HttpHeaders headers) {
		log.info("进入:" + myName + "headers:" + headers.toString());
		String passportId = headers.get("passportId").get(0);
		String sessionId = headers.get("sessionId").get(0);

		Map<String, String> map = new HashMap<String, String>();
		map.put("passportId", passportId);
		map.put("sessionId", sessionId);

		return OpenResult.ok().add("data", map).buildJsonNew();

	}
}
