package com.lxd.test.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

public class HelloService {

//	@Autowired
//	private RestTemplate restTemplate;
//
//	@HystrixCommand
//	public User getUserByid(Long id) {
//		return restTemplate.getForObject("http://USER-SERVICE/users/{1}", User.class, id);
//	}
//
//	@HystrixCommand
//	public Future<User> getUserByidAsync(final String id) {
//	return new AsyncResult<User>() 
//	{
//	@Override
//	public User invoke() 
//	{
//	return restTemplate.getForObject("http://USER-SERVICE/users/{1}",
//	User.class, id); 
//	}
//}
//	}
	
	
//	@HystrixCommand(fallbackMethod = "defaultUser")
//	public User getUserByid(Long id) {
//	return restTemplate.getForObject("ht七p://USER-SERVICE/users/(1)",
//	User.class, id); 
//	}
//	
//	public User defaultUser() {
//		return new User(); 
//	}	
	
	
}