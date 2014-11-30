package com.hkntv.cms.login.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hkntv.cms.domain.User;
import com.hkntv.cms.login.service.LoginService;

@Controller
public class LoginAjaxController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * 将@ResponseBody注解到方法上面，且方法返回值为字符串，则将会以json返回
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/loginAjax",method=RequestMethod.POST)
	@ResponseBody
	public String login(User user){
		if(loginService.authenticate(user)){
			return "成功登陆";
		}else{
			return "登陆失败";
		}
	}
	
	/**
	 * 将@ResponseBody注解到返回值前面，且方法返回值为对象，springmvc将会将该对象封装成json
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public @ResponseBody User handle1(User user){
		return new User();
	}
}

