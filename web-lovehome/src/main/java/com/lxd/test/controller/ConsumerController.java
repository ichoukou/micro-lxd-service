package com.lxd.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value = "ribbon-consumer", method = RequestMethod.GET)
	public String HelloConsumer() {

		String url = "http://service-housing/housing/2";

		String reback = restTemplate.getForEntity(url, String.class).getBody();
		return reback;

	}
}
