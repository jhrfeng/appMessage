package com.jing.maven.account.model;

import com.jing.maven.account.response.OtherAccountRes;
import com.jing.maven.manager.entity.Message;

public class OtherAccountVo extends Message{
	
	private String className = "OtherAccountVo";
	
	/**
	 * responseBody 第三方账号信息
	 */
	private  OtherAccountRes otherAccount;

	public OtherAccountRes getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(OtherAccountRes otherAccount) {
		this.otherAccount = otherAccount;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
    
	
}
