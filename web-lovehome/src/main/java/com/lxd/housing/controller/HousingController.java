package com.lxd.housing.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lxd.housing.service.HousingService;

@RestController
@RequestMapping("housing")
public class HousingController {

	private static final Logger logger = LoggerFactory.getLogger(HousingController.class);
	
    @Autowired
    HousingService housingService;
    
    @RequestMapping(value = "info/{housingId}", method = RequestMethod.GET)
    public String housingInfo(@PathVariable Integer housingId) {
    	
    	return housingService.helloService(housingId);
    }
	

}
