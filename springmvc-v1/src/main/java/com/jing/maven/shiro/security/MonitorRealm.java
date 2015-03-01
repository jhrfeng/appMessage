package com.jing.maven.shiro.security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.shiro.cache.Cache;

import com.jing.maven.account.dao.ThridAccountDao;



@Component
public class MonitorRealm extends AuthorizingRealm {
	
	
	public MonitorRealm() {
		super();
	}
	
	@Autowired 
	private ThridAccountDao thridAccountDao;
	
	@SuppressWarnings("rawtypes")
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {	
	
		String accountInfo = (String) super.getAvailablePrincipal(principals);
      	SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
      	if(accountInfo != null){
      		return info;
      	}else{
      		throw new AuthorizationException(); 
      	}
	}
	


	@SuppressWarnings("rawtypes")
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
																throws AuthenticationException {
        SimpleAuthenticationInfo info = null;  
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        UsernamePasswordToken usToken = (UsernamePasswordToken) token;
        String account = usToken.getUsername();
        char[] type = usToken.getPassword();
        Long status = null;
        if("1".equals(type[0])){ //QQ
        	status = thridAccountDao.getQQ(account);
        }else{ //weixin
        	status = thridAccountDao.getWeiXin(account);
        }
        if(null!=status && status ==1 ){
        	info = new SimpleAuthenticationInfo(null, type, getName());
        }
        return info;
    
	}

    /**
     * 娓呴櫎鎵�湁鐢ㄦ埛鎺堟潈淇℃伅缂撳瓨.
     */ 
    public void clearAllCachedAuthorizationInfo() { 
        Cache<Object, AuthorizationInfo> cache = getAuthorizationCache(); 
        if (cache != null) { 
            for (Object key : cache.keys()) { 
                cache.remove(key); 
            } 
        } 
    } 
	
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals =
			new SimplePrincipalCollection(principal, getName());
		
		clearCachedAuthorizationInfo(principals);
	}
	
}