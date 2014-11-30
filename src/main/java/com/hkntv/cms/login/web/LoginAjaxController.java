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
	 * ��@ResponseBodyע�⵽�������棬�ҷ�������ֵΪ�ַ������򽫻���json����
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/loginAjax",method=RequestMethod.POST)
	@ResponseBody
	public String login(User user){
		if(loginService.authenticate(user)){
			return "�ɹ���½";
		}else{
			return "��½ʧ��";
		}
	}
	
	/**
	 * ��@ResponseBodyע�⵽����ֵǰ�棬�ҷ�������ֵΪ����springmvc���Ὣ�ö����װ��json
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public @ResponseBody User handle1(User user){
		return new User();
	}
}

