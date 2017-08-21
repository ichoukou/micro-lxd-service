package com.lxd.housing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class HousingService {

	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService(Integer housingId) {

		String url = "http://service-housing/housing/" + housingId;

		String reback = restTemplate.getForEntity(url, String.class).getBody();
		return reback;
	}

	public String helloFallback(Integer housingId) {

		return "error" + housingId;

	}
}
