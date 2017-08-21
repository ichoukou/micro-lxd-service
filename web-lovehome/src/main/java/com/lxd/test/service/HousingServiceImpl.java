package com.lxd.test.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by summer on 2017/5/15.
 */
@Component
public class HousingServiceImpl implements HousingService{

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "hello " +name+", this messge send failed ";
    }
}
