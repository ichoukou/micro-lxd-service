package com.lxd.customer.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lxd.customer.dao.TestDao;

@RequestMapping("/refactor")
public interface CustomerServcie {

	
	@RequestMapping(value = "hello4", method = RequestMethod.GET)
	String hello(@RequestParam("name") String name);
	
	@RequestMapping(value = "hello5", method = RequestMethod.GET)
	TestDao index(@RequestHeader("testId") Integer testId, @RequestHeader("testName") String testName);
	
	@RequestMapping(value = "/hello6", method= RequestMethod.POST)
	String index(@RequestBody TestDao testDao);

}
