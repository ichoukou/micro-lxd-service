package com.lxd.housing.dao;

import com.lxd.housing.model.Housing;

public interface HousingMapper {
	
	Housing getById(Integer housingId);

	int insert(Housing record);
	
	int update(Housing record);
	
	int deleteById(Integer housingId);

}