package com.hkntv.cms.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {

	private String name1;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
