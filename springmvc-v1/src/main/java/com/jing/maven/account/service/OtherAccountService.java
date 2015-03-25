package com.jing.maven.account.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.maven.account.dao.OtherAccountDao;
import com.jing.maven.account.dao.ThridAccountDao;
import com.jing.maven.account.entity.OtherAccountPO;
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.model.OtherAccountVo;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.account.request.OtherAccountReq;
import com.jing.maven.common.system.BaseService;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendStatusPO;


@Service
public class OtherAccountService extends BaseService{
	
	@Autowired
	private OtherAccountDao otherAccountDao;
	
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
	public OtherAccountVo accountLogin(OtherAccountReq account){
		
		OtherAccountVo accountVo = new OtherAccountVo();
		try{		
			OtherAccountPO otherAccount = 
					otherAccountDao.findByAppIdAndType(account.getAppId(), account.getType());
			if(null != otherAccount){ //已注册
				if(null==otherAccount.getMac()){
					otherAccount.setMac(account.getMac());
					otherAccount.setAppToken(account.getAppToken());
					otherAccount.setUpdateDate(formatUpdateDate(new Date()));
					otherAccountDao.save(otherAccount);
				}
				FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(otherAccount.getTid());
				accountVo.setFriendStatus(friendStatus);
				accountVo.setOptStatus(true);
				accountVo.setMessage("登录成功");
				return accountVo;	
			}else{
				accountVo.setOptStatus(false);
				accountVo.setMessage("登录失败，未获取到登录类型");
				accountVo.setOptCode("100");
				return accountVo;
			}
		}catch(Exception e){
			e.printStackTrace();
			accountVo.setOptStatus(false);
			accountVo.setMessage("登录异常");
			return accountVo;
		}

	}
}
