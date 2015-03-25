package com.jing.maven.shiro.security;

import java.util.Date;

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

import com.jing.maven.account.dao.OtherAccountDao;
import com.jing.maven.account.dao.ThridAccountDao;
import com.jing.maven.account.entity.OtherAccountPO;
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.service.ThridAccountService;
import com.jing.maven.common.util.EncryptUtils;
import com.jing.maven.common.util.JsonUtils;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;



@Component
public class MonitorRealm extends AuthorizingRealm {

	@Autowired
	private OtherAccountDao otherAccountDao;

	@Autowired
	private InfomationDao infomationDao;
	
	@Autowired
	private FriendStatusDao friendStatusDao;
	
	@Autowired
	private ThridAccountService thridAccountService;
	
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
        Long status = otherAccountDao.findcountByAppIdAndType(account, type.toString());
        if(null==status || status ==0 ){
        	accountLogin(type[0]+"", account); //进行注册
        }
        info = new SimpleAuthenticationInfo(account, type, getName());
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
	
	public void accountLogin(String type, String account){
		AccountVo accountVo = new AccountVo();
		try{	
			
			OtherAccountPO otherAccount = otherAccountDao.findByAppIdAndType(account, type);
			if(null != otherAccount){
				FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(otherAccount.getTid());
				accountVo.setFriendStatus(friendStatus);
			}else{
				//生成个人信息表
				InfomationPO info = new InfomationPO();
				info.setCreateDate(JsonUtils.formatDate(new Date()));
				info.setUpdateDate(JsonUtils.formatDate(new Date()));
				infomationDao.save(info);
				
				//生成账号系统
				OtherAccountPO generateAccount = new OtherAccountPO();
				generateAccount.setAppId(account);
				generateAccount.setInfoid(info.getTid());
				generateAccount.setType(type);
				generateAccount.setCreateDate(JsonUtils.formatDate(new Date()));
				generateAccount.setUpdateDate(JsonUtils.formatDate(new Date()));
				otherAccountDao.save(generateAccount);
				
				//生成语音账号
				FriendStatusPO friendStatus = new FriendStatusPO();
				friendStatus.setMyinfoId(info.getTid());
				friendStatus.setSipAccount(generateAccount.getTid());
				friendStatus.setSipPwd(EncryptUtils.string2MD5(generateAccount.getTid()));
				friendStatus.setStatus("1"); //状态
				friendStatusDao.save(friendStatus);
				
				accountVo.setFriendStatus(friendStatus);
			}
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
}