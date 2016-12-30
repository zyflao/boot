package com.zyf.web;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zyf.dao.Seckill;
import com.zyf.service.SeckillService;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/seckill")
public class SeckillAction extends BaseService {
	Logger log = Logger.getLogger(Example.class);

	@Autowired
	SeckillService seckillService;

	@RequestMapping(value = "/")
	String home() {
		log.info("seckillService");
		List<Seckill> list = seckillService.query();
		return OpenResult.ok().add("data", list).buildJsonNew();

	}
}
