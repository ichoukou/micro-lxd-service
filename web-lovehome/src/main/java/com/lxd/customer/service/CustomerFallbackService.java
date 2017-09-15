package com.lxd.customer.service;

import org.springframework.stereotype.Component;

import com.lxd.customer.dao.TestDao;

@Component
public class CustomerFallbackService implements CustomerServcie {

	@Override
	public String helloCustomer() {
		return "error";
	}

	@Override
	public String hello(String name) {
		return "error";
	}

	@Override
	public TestDao index(Integer testId, String testName) {
		return new TestDao(0, "weizhi");
	}

	@Override
	public String index(TestDao testDao) {
		return "error";
	}

}
