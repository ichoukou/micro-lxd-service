package com.lxd.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lxd.customer.dao.TestDao;
import com.lxd.customer.service.CustomerServcie;

@RestController
public class CustomerController {

	@Autowired
	CustomerServcie customerService;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String index() {
		return customerService.helloCustomer();
	}

	@RequestMapping(value = "/customer1", method = RequestMethod.GET)
	public String index2() {

		StringBuilder sb = new StringBuilder();

		sb.append(customerService.hello("lxdd")).append("\n");
		sb.append(customerService.index(31, "lxdddd")).append("\n");
		sb.append(customerService.index(new TestDao(24, "ceshiren"))).append("\n");

		return sb.toString();

	}

}
