package com.lxd.housing.service;

import org.springframework.stereotype.Service;

@Service
public class HousingService {

//	@Autowired
//	RestTemplate restTemplate;

	//@HystrixCommand(fallbackMethod = "helloFallback")
	public String helloService(Integer housingId) {

		String url = "http://service-housing/housing/" + housingId;

//		String reback = restTemplate.getForEntity(url, String.class).getBody();
		return null;
	}

	public String helloFallback(Integer housingId) {

		return "error" + housingId;

	}
}
