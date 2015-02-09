package com.jing.maven.system.model;

import com.jing.maven.manager.entity.Message;

public class CompanyInfo extends Message{
	
	private String aboutUs = "关于我们：成立于2015年4月1日";

	public String getAboutUs() {
		return aboutUs;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}
	
	

}
