package com.lxd.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class LoginController {

	@RequestMapping(value = "/")
	public ModelAndView index() {

		// 构建ModelAndView实例，并设置跳转页面
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("name", "lxd");

		return mv;
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpServletRequest request) {
		return null;
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
