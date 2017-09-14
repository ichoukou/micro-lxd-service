package com.lxd.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxd.customer.dao.TestDao;

@RestController
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@RequestMapping("/customer/hello")
	public String index() {

		logger.info("I come in");

		return "Hi, lixiaodong";
	}

	@RequestMapping(value = "hello1", method = RequestMethod.GET)
	public String index(@RequestParam String name) {

		return "Hello" + name;

	}

	@RequestMapping(value = "hello2", method = RequestMethod.GET)
	public TestDao index(@RequestHeader Integer testId, @RequestHeader String testName) {

		return new TestDao(testId, testName);
	}

	@RequestMapping(value = "hello3", method = RequestMethod.POST)
	public String index(@RequestBody TestDao testDao) {

		return "Hello " + testDao.getTestId() + testDao.getTestName();
	}

}