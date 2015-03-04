package com.jing.maven.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jing.maven.account.dao.ThridAccountDao;
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendStatusPO;


@Service
public class ThridAccountService {
	
	@Autowired
	private ThridAccountDao thridAccountDao;
	
	@Autowired
	private InfomationDao infomationDao;
	
	@Autowired
	private FriendStatusDao friendStatusDao;
	
	
	/**
	 * 第三方登录
	 * @param account
	 * @return
	 */
	public AccountVo accountLogin(ThridAccountVo account){
		
		AccountVo accountVo = new AccountVo();
		try{			
			if("1".equals(account.getType())){// 1为QQ
				ThridAccountPO qq = thridAccountDao.findByQQ(account.getOpenId());
				if(null!=qq){ //已注册
					if(null==qq.getMac()){
						qq.setMac(account.getMac());
						qq.setAccessToken(account.getAccessToken());
						qq.setUpdateDate("2012/12/12");
						thridAccountDao.save(qq);
					}					
					FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(qq.getTid());
					accountVo.setFriendStatus(friendStatus);
				}	
			}else if("2".equals(account.getType())){ //为微信
				ThridAccountPO weixin = thridAccountDao.findByWeiXin(account.getAppId());
				if(null!=weixin){ //已注册
					if(null==weixin.getMac()){
						weixin.setMac(account.getMac());
						weixin.setSecret(account.getSecret());
						weixin.setUpdateDate("2012/12/12");
						thridAccountDao.save(weixin);
					}		
					FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(weixin.getTid());
					accountVo.setFriendStatus(friendStatus);
				}
			}else{
				accountVo.setOptStatus(false);
				accountVo.setMessage("登录失败，未获取到登录类型");
				accountVo.setOptCode("100");
			}
		
			accountVo.setOptStatus(true);
			accountVo.setMessage("登录成功");
			return accountVo;	
		
		}catch(Exception e){
			e.printStackTrace();
			accountVo.setOptStatus(false);
			accountVo.setMessage("登录异常");
			return accountVo;
		}

	}

	

}
