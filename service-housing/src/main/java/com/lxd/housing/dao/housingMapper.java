package com.lxd.housing.dao;

import com.lxd.housing.model.housing;

public interface housingMapper {
    int deleteByPrimaryKey(Integer housingId);

    int insert(housing record);

    int insertSelective(housing record);

    housing selectByPrimaryKey(Integer housingId);

    int updateByPrimaryKeySelective(housing record);

    int updateByPrimaryKey(housing record);
}