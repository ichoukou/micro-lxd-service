package com.lxd.test.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by li_xiaodong on 2017/5/11.
 */
@FeignClient(name= "service-housing", fallback = HousingServiceImpl.class)
public interface HousingService {

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam(value = "name") String name);

}
