package com.lxd.housing.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lxd.core.support.ResultData;
import com.lxd.core.util.JsonUtil;
import com.lxd.housing.dto.HousingDto;
import com.lxd.housing.model.Housing;
import com.lxd.housing.service.HousingService;

@RestController
@RequestMapping("housing")
public class HousingController {

	private static final Logger logger = LoggerFactory.getLogger(HousingController.class);

	@Resource(name = "housingService")
	private HousingService housingService;

	@RequestMapping(value = "/q/{param}", method = RequestMethod.GET)
	public String list(@PathVariable String param) {
		// 构建返回
		ResultData<List<HousingDto>> resultData = new ResultData<List<HousingDto>>();

		try {
			Map<?, ?> queryParam = JsonUtil.parseToObject(param, Map.class);

			resultData = housingService.queryList(queryParam);
		} catch (Exception e) {

			logger.error("input params: " + param, e);

			resultData.setFail();
		}

		return resultData.toString();
	}

	@RequestMapping(value = "/{housingId}", method = RequestMethod.GET)
	public String getById(@PathVariable Integer housingId) {

		// 构建返回
		ResultData<HousingDto> resultData = new ResultData<>();

		try {

			Housing mo = housingService.getById(housingId);

			// Model转换Dto
			HousingDto dto = new HousingDto();
			
			if(null != mo) {
				BeanUtils.copyProperties(mo, dto);
			}

			

			resultData.setReturnData(dto);

		} catch (Exception e) {

			logger.error("input params: " + housingId, e);

			resultData.setFail();
		}

		return resultData.toString();

	}

	/**
	 * @param jsonDto
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@RequestBody String jsonDto) {

		// 构建返回
		ResultData<HousingDto> resultData = new ResultData<>();

		try {
			HousingDto dto = JsonUtil.parseToObject(jsonDto, HousingDto.class);

			Housing mo = new Housing();

			// 赋值
			BeanUtils.copyProperties(dto, mo);

			int count = housingService.insert(mo);
			if (count <= 0) {
				resultData.setFail("sql执行结果为0");
			}
		} catch (Exception e) {

			logger.error("input params: " + jsonDto, e);

			resultData.setFail();
		}

		return resultData.toString();
	}

	/**
	 * 更新
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public String update(@RequestBody String jsonStr) {

		// 构建返回
		ResultData<HousingDto> resultData = new ResultData<>();

		try {
			HousingDto dto = JsonUtil.parseToObject(jsonStr, HousingDto.class);

			Housing mo = new Housing();

			// 赋值
			BeanUtils.copyProperties(dto, mo);

			int count = housingService.update(mo);
			if (count <= 0) {
				resultData.setFail("sql执行结果为0");
			}
		} catch (Exception e) {

			logger.error("input params: " + jsonStr, e);

			resultData.setFail();
		}

		return resultData.toString();
	}

	/**
	 * 删除
	 *
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable int id) {

		// 构建返回
		ResultData<?> resultData = new ResultData<>();

		try {
			int count = housingService.delete(id);
			if (count <= 0) {
				resultData.setFail("sql执行结果为0");
			}
		} catch (Exception e) {

			logger.error("input params: id=" + id, e);

			resultData.setFail();
		}

		return resultData.toString();
	}

}
