package com.hkntv.cms.login.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hkntv.cms.domain.User;
import com.hkntv.cms.login.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 返回值为 "forward:"进行forward跳转
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView login(User user){
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("user", user);
		mv.setViewName("forward:/loginIndex");
		return mv;
	}
	
	/**
	 * 返回值为 "redirect:"进行redirect跳转
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/check",method=RequestMethod.GET)
	public String handle1(User user){
		if(loginService.authenticate(user)){
			return "redirect:www.sina.com.cn";
		}
		return "redirect:www.baidu.com";
	}
	
	/**
	 * 返回值为 /hello,则将跳转到/WEB-INF/jsp/hello.jsp
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/loginIndex",method=RequestMethod.GET)
	@ResponseBody
	public User loginIndex(){
		User user =new User();
		user.setName("lhaiq");
		user.setPassword("dasdas");
		return user;
	}
}

