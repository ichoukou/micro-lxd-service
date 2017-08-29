package com.lxd.login.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.lxd.base.controller.BaseController;
import com.lxd.core.support.Constant;
import com.lxd.core.support.ResultData;
import com.lxd.core.support.ReturnCode;
import com.lxd.core.support.ReturnView;
import com.lxd.login.dto.LoginDto;
import com.lxd.login.service.LoginService;

@RestController
public class LoginController extends BaseController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Resource(name = "loginService")
	private LoginService loginService;

	@RequestMapping(value = "/")
	public ModelAndView index() {

		// 构建ModelAndView实例，并设置跳转页面
		ModelAndView mv = new ModelAndView("index");

		mv.addObject("name", "lxd");

		return mv;
	}

	/**
	 * 登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ReturnView<?, ?> login(HttpServletRequest request) {

		// 返回map
		Map<String, Object> rspMap = new HashMap<String, Object>();

		// 获取map
		Map<String, Object> reqMap = bindParamToMap(request);

		String username = (String) reqMap.get("username");
		String password = (String) reqMap.get("password");

		// 验证码校验

		// 判空
		if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
			rspMap.put(Constant.RETURN_CODE_KEY, ReturnCode.FAILURE);
			rspMap.put(Constant.RETURN_MSG_KEY, "用户名或密码不正确");
			return getOperateJSONView(rspMap);
		}

		ResultData<?> resultData = new ResultData<>();

		LoginDto loginDto = new LoginDto();
		loginDto.setLoginName(username);
		loginDto.setPassword(password);
		loginDto.setSystemCode("lovehome");

		try {

			resultData = loginService.login(loginDto);

		} catch (Exception e) {

			logger.error(loginDto.toString(), e);

			rspMap.put(Constant.RETURN_CODE_KEY, ReturnCode.FAILURE);

			rspMap.put(Constant.RETURN_MSG_KEY, "登录异常");

			return getSearchJSONView(rspMap);

		}

		// UserInfo userInfo = new UserInfo();
		if (ReturnCode.SUCCESS.equals(resultData.getReturnCode())) {

		} else {
			rspMap.put(Constant.RETURN_CODE_KEY, resultData.getReturnCode());
			rspMap.put(Constant.RETURN_MSG_KEY, resultData.getReturnMsg());
			return getSearchJSONView(rspMap);

		}

		// 存放userInfo
		// UserInfoHolder.set(userInfo);

		// 用户信息放session
		// WebUtil.addSession(request, Constant.SESSION_KEY_USERINFO, userInfo);

		return getOperateJSONView(rspMap);
	}

	/**
	 * 退出
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout() {

		// 构建ModelAndView实例，并设置跳转页面
		ModelAndView mv = new ModelAndView("redirect:/index.jsp");

		return mv;

	}

}
