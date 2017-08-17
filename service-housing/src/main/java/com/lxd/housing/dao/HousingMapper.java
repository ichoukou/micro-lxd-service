package com.lxd.housing.dao;

import org.apache.ibatis.annotations.Mapper;

import com.lxd.core.dao.IDao;
import com.lxd.housing.model.Housing;

@Mapper
public interface HousingMapper extends IDao<Housing>{
	

}