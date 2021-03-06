package com.lxd.core.util;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**   
* (json对象辅助类)
* @author (li_xiaodong)
* @date 2015年10月14日 下午7:50:03
*/
@Component
public class JsonUtil
{
    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    
    private static final ObjectMapper mapper;
    
    static
    {
        //readMapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
        mapper = new ObjectMapper();
        mapper.setDateFormat(dateFormat);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }
    
    /** 
    * (json转为Object)
    * @param json
    * @param toClass
    * @return
    */
    public static <T> T parseToObject(String json, Class<T> toClass)
    {
        try
        {
            return (T)mapper.readValue(json, toClass);
        }
        catch (Exception e)
        {
            throw new RuntimeException("将json字符转换为对象时失败!");
        }
    }
    
    /** 
    * (Object转为json)
    * @param obj
    * @return
    */
    public static String parseToJson(Object obj)
    {
        if (obj == null)
        {
            return null;
        }
        
        try
        {
            return mapper.writeValueAsString(obj);
        }
        catch (Exception e)
        {
            throw new RuntimeException("转换json字符失败!");
        }
    }
    
    
    

    
}
