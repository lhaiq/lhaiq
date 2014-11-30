package com.hkntv.cms.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hkntv.cms.domain.User;
import com.hkntv.cms.login.repository.LoginRepository;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginRepository;
	
	public boolean authenticate(User user){
		return loginRepository.authenticate(user);
	}
	
}
