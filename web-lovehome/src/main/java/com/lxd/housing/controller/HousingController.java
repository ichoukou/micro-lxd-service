package com.lxd.housing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("housing")
public class HousingController {

	// private Logger logger =

	@RequestMapping(value = "/init", method = RequestMethod.GET)
	public ModelAndView hello() {

		// 构建ModelAndView实例，并设置跳转页面
		ModelAndView mv = new ModelAndView("housing/greet");

		mv.addObject("name", "lx22222ddd333d");

		//
		return mv;
	}
	
    /**
     * 测试hello
     * @return
     */
    @RequestMapping(value = "/hello12",method = RequestMethod.GET)
    public String hello(Model model) {
        model.addAttribute("name", "Dear");
        return "housing";
    }

}
