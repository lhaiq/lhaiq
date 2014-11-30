package com.hkntv.cms.login.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hkntv.cms.domain.User;

@Repository
public class LoginRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public boolean authenticate(User user){
		if("lhaiq".equals(user.getName())){
			return true;
		}else{
			return false;
		}
	}
	
}
