package com.lxd.housing.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.lxd.core.support.ResultData;
import com.lxd.housing.dao.HousingMapper;
import com.lxd.housing.dto.HousingDto;
import com.lxd.housing.model.Housing;

@Service("housingService")
public class HousingService {

	@Resource
	private HousingMapper housingMapper;

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 */

	public Housing getById(int id) throws Exception {
		Housing housing = housingMapper.getById(id);
		return housing;
	}

	/**
	 * 创建
	 * 
	 * @param param
	 * @return
	 */

	public int insert(Housing housing) throws Exception {
		int count = housingMapper.create(housing);
		return count;
	}

	/**
	 * 更新
	 * 
	 * @param param
	 * @return
	 */

	public int update(Housing housing) throws Exception {
		int count = housingMapper.update(housing);
		return count;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */

	public int delete(int id) throws Exception {
		int count = housingMapper.deleteById(id);
		return count;
	}

	public ResultData<List<HousingDto>> queryList(Map<?, ?> param) throws Exception {

		// 构建返回
		ResultData<List<HousingDto>> resultData = new ResultData<List<HousingDto>>();

		// 查询
		final List<Housing> moList = housingMapper.queryList(param);

		// 转换
		List<HousingDto> dtoList = convertData(moList);

		// resultData.setTotalCount((String) param.get(QueryConst.TOTAL_COUNT));

		resultData.setReturnData(dtoList);

		return resultData;
	}

	/**
	 * 对象转换MO--DTO
	 * 
	 * @param stuList
	 * @return List<HousingDto>
	 */
	private List<HousingDto> convertData(List<Housing> moList) throws Exception {
		List<HousingDto> dtoList = new ArrayList<HousingDto>();

		if (null != moList && !moList.isEmpty()) {
			HousingDto dto = null;
			for (Housing mo : moList) {
				dto = new HousingDto();
				BeanUtils.copyProperties(mo, dto);
				dtoList.add(dto);
			}
		}
		return dtoList;
	}
}
