package com.lxd.housing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lxd.housing.dao.HousingMapper;
import com.lxd.housing.model.Housing;

@Service("housingService")
public class HousingService {
	
    @Resource
    private HousingMapper housingMapper;
    
    /** 
    * 查询
    * @param id
    * @return
    */
    
    public Housing getById(int id)
        throws Exception
    {
    	Housing housing = housingMapper.getById(id);
        return housing;
    }
    

	/** 
     * 创建
     * @param param
     * @return
     */
    
    public int insert(Housing housing)
        throws Exception
    {
        int count = housingMapper.insert(housing);
        return count;
    }
    
    /** 
     * 更新
     * @param param
     * @return
     */
    
    public int update(Housing housing)
        throws Exception
    {
        int count = housingMapper.update(housing);
        return count;
    }
    
    /** 
    * 删除
    * @param id 
    * @return
    */
    
    public int delete(int id)
        throws Exception
    {
        int count = housingMapper.deleteById(id);
        return count;
    }
}
			