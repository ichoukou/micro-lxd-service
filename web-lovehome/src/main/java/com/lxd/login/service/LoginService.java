package com.lxd.login.service;

import org.springframework.stereotype.Service;

import com.lxd.core.support.ResultData;
import com.lxd.login.dto.LoginDto;

@Service
public class LoginService {
	
	/**
	 * 登录
	 * 
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public ResultData<?> login(LoginDto dto) throws Exception {
		// 调用 接口
		String url = "login";

		ResultData<?> backResult = new ResultData<>();

		return backResult;

	}
}
