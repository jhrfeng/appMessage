package com.jing.maven.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.maven.account.dao.ThridAccountDao;
import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.common.util.EncryptUtils;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;

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
					thridAccount.setOpenId(account.getOpenId());
					thridAccount.setAccessToken(account.getAccessToken());
					thridAccount.setInfoid(info.getTid());
					thridAccount.setMac(account.getMac());
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
			}else if("2".equals(account.getType())){ //为微信
				ThridAccountPO weixin = thridAccountDao.findByWeiXin(account.getAppId());
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
					thridAccount.setAppId(account.getAppId());
					thridAccount.setSecret(account.getSecret());
					thridAccount.setMac(account.getMac());
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
