package com.jing.maven.shiro.security;

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
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.service.ThridAccountService;
import com.jing.maven.common.util.EncryptUtils;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;



@Component
public class MonitorRealm_bak extends AuthorizingRealm {
	
	
	public MonitorRealm_bak() {
		super();
	}
	
	@Autowired 
	private ThridAccountDao thridAccountDao;

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
        Long status = null;
        if("1".equals(type[0]+"")){ //QQ
        	status = thridAccountDao.getQQ(account);
        }else{ //weixin
        	status = thridAccountDao.getWeiXin(account);
        }
        if(null!=status && status ==1 ){
        	
        }else{
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
			if("1".equals(type)){// 1为QQ
				ThridAccountPO qq = thridAccountDao.findByQQ(account);
				if(null!=qq){ //已注册
					FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(qq.getTid());
					accountVo.setFriendStatus(friendStatus);
				}else{
					
					//生成个人信息表
					InfomationPO info = new InfomationPO();
					info.setCreateDate("2012/12/12");
					info.setUpdateDate("2112/12/12");
					infomationDao.save(info);
					
					//生成账号系统
					ThridAccountPO thridAccount = new ThridAccountPO();
					thridAccount.setOpenId(account);
			
					thridAccount.setInfoid(info.getTid());

					thridAccount.setCreateDate("2012/12/12");
					thridAccount.setUpdateDate("2012/12/12");
					thridAccountDao.save(thridAccount);
					
					/***************************************/
					
					//生成语音账号	
					FriendStatusPO friendStatus = new FriendStatusPO();
					friendStatus.setMyinfoId(info.getTid());
					friendStatus.setSipAccount(thridAccount.getTid());
					friendStatus.setSipPwd(EncryptUtils.string2MD5(thridAccount.getTid()));
					friendStatus.setStatus("1"); //在线
					friendStatusDao.save(friendStatus);
					
					/***************************************/
					accountVo.setFriendStatus(friendStatus);				
				}			
			}else if("2".equals(type)){ //为微信
				ThridAccountPO weixin = thridAccountDao.findByWeiXin(account);
				if(null!=weixin){ //已注册
					FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(weixin.getTid());
					accountVo.setFriendStatus(friendStatus);
				}else{
					//生成个人信息表
					InfomationPO info = new InfomationPO();
					info.setCreateDate("2012/12/12");
					info.setUpdateDate("2112/12/12");
					infomationDao.save(info);
					
					//生成账号系统
					ThridAccountPO thridAccount = new ThridAccountPO();
					thridAccount.setAppId(account);
					
					thridAccountDao.save(thridAccount);
					
					/***************************************/
					
					//生成语音账号	
					FriendStatusPO friendStatus = new FriendStatusPO();
					friendStatus.setMyinfoId(info.getTid());
					friendStatus.setSipAccount(thridAccount.getTid());
					friendStatus.setSipPwd(EncryptUtils.string2MD5(thridAccount.getTid()));
					friendStatus.setStatus("1"); //在线
					friendStatusDao.save(friendStatus);
					
					/***************************************/
					accountVo.setFriendStatus(friendStatus);				
				}
			}
		
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	
}