package com.lxd.housing.controller;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lxd.housing.model.Housing;
import com.lxd.housing.service.HousingService;

@RestController
public class HousingController {
	
	@Resource(name="housingService")
	private HousingService housingService;

	@RequestMapping("/hello")
	public String index(@RequestParam String name) {
		return "hello " + name + "，this is first messge";
	}

	/**
	 * 创建
	 *
	 * @param jsonDto
	 *            对象字符串
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@RequestBody String jsonDto) {

		

		try {
			//HousingDto dto = JsonUtil.parseToObject(jsonDto, HousingDto.class);

			Housing mo = new Housing();

			// 赋值
			//BeanUtils.copyProperties(dto, mo);

			int count = housingService.insert(mo);
			if (count <= 0) {
				//resultData.setFail("创建记录结果为0");
			}
		} catch (Exception e) {

			//resultData.setFail();
		}

		return null;
	}

}
