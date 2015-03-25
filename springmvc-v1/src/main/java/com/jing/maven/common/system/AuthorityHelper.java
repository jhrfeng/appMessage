package com.jing.maven.common.system;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import com.jing.maven.common.model.UserVo;
import com.jing.maven.infomation.entity.FriendStatusPO;

public class AuthorityHelper {

	 
    public static UserVo userVo = null; 
    
	static {
		if(SecurityUtils.getSubject().isAuthenticated())
			init();
	}

	
	/**
	 * 初始化数据,将参数进行缓存
	 * 
	 * @author jinghr
	 */
	protected static void init() {
		if(null == userVo){			
			userVo = getUser();
		}
	}
	
	public static UserVo user(){
		if(null != userVo){			
			userVo = getUser();
		}
		return userVo;
	}
	
	public static UserVo getUser(){
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		FriendStatusPO sessionInfo = (FriendStatusPO)session.getAttribute("sysUserInfo");
		UserVo userVo = new UserVo(); 
		userVo.setAccountId(sessionInfo.getSipAccount());
		userVo.setInfoId(sessionInfo.getMyinfoId());
		return userVo;
	}
}
