package com.jing.maven.common.system;

import org.apache.shiro.SecurityUtils;

public class BaseController {
	
	public Boolean authLogin(){
		if(SecurityUtils.getSubject().isAuthenticated())
			return true;
		else
			return false;
	}

}
