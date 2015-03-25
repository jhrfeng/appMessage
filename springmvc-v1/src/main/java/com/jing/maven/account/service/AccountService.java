package com.jing.maven.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.maven.account.dao.AccountDao;
import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.common.util.EncryptUtils;
import com.jing.maven.common.util.MathUtils;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private InfomationDao infomationDao;
	
	@Autowired
	private FriendStatusDao friendStatusDao;

	/**
	 * APP登录
	 * @param account
	 * @return
	 */
	public AccountVo accountLogin(AccountPO account){
		
		AccountVo accountVo = new AccountVo();
		AccountPO loginAccount = accountDao.findByAccount(account.getAccount());
		if(null == loginAccount){
			accountVo.setOptStatus(false);
			accountVo.setMessage("不存在该账号");
		}else{
			String pwd = EncryptUtils.encryptMD5(account.getPassword()+"");
			if(pwd.equals(loginAccount.getPassword())){
				/***********************/			
				//返回语音账号 和 密码 (设置状态为在线)
				FriendStatusPO friendStatus = friendStatusDao.findBySipAccount(account.getAccount());
				friendStatus.setStatus("1");
				friendStatusDao.save(friendStatus);
				accountVo.setFriendStatus(friendStatus);
			//	accountVo.setAccount(loginAccount);
				
				/**********************/				
				accountVo.setOptStatus(true);
				accountVo.setMessage("登录成功");
			}else{
				accountVo.setOptStatus(false);
				accountVo.setMessage("密码不正确");
			}	
		}
		
		return accountVo;
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	public AccountVo accountRegister(AccountPO account){
		AccountVo accountVo = new AccountVo();
		try{		
			String pwd = account.getPassword();
			Long count = accountDao.countByAccount(account.getAccount());
			if(count > 0){
				accountVo.setOptStatus(false);
				accountVo.setMessage("该账号已存在");
				return accountVo;
			}
			//生成个人信息表
			InfomationPO info = new InfomationPO();
			info.setCreateDate("2012/12/12");
			info.setUpdateDate("2112/12/12");
			infomationDao.save(info);
			
			
			//生成注册账号
			account.setPassword(EncryptUtils.encryptMD5(pwd));
			account.setCreateDate("2012/12/12");
			account.setUpdateDate("2012/12/12");
			account.setUpdateid(info.getTid());
			account.setInfoid(info.getTid());
			accountDao.save(account);
			
			/***************************************/
			
			//生成语音账号	
			FriendStatusPO friendStatus = new FriendStatusPO();
			friendStatus.setMyinfoId(info.getTid());
			friendStatus.setSipAccount(account.getAccount());
			friendStatus.setSipPwd(EncryptUtils.string2MD5(pwd));
			friendStatus.setStatus("1"); //在线
			friendStatusDao.save(friendStatus);
			
			/***************************************/
			
			accountVo.setFriendStatus(friendStatus);
			accountVo.setOptStatus(true);
			accountVo.setMessage("注册成功");
			return accountVo;
			
		}catch(Exception e){
			e.printStackTrace();
			accountVo.setOptStatus(false);
			accountVo.setMessage("注册失败");
			return accountVo;
		}
	}
	
	/**
	 * APP修改密码
	 * @param account
	 * @return
	 */
	public Message updatePwd(AccountPO account){
		Message message = new Message();
		try{
			AccountPO updateAccount = accountDao.findOne(account.getTid()); //获取当前登录用户id
			updateAccount.setPassword(EncryptUtils.encryptMD5(account.getPassword()));
			updateAccount.setUpdateDate("2012/12/12");
			/** 日志记录信息  **/
			
			
			accountDao.save(updateAccount);
			message.setOptStatus(true);
			message.setMessage("修改密码成");
			return message;
		}catch(Exception e){
		    /** 日志记录信息  **/
			message.setOptStatus(false);
			message.setMessage("密码修改失败");
			return message;
		}
	}
	
	/**
	 * APP找回密码
	 * @param account
	 * @return
	 */
	public Message getAccountPwd(AccountPO account){
		Message message = new Message();
		try{
			/** 邮件发送重置密码， 密码随机生成 **/
			String resetPwd = MathUtils.generateRandom6();
			AccountPO resetAccount = accountDao.findByAccount(account.getAccount());
			if(null != resetAccount){
				resetAccount.setPassword(resetPwd);
				resetAccount.setUpdateDate("2012/12/11");
				accountDao.save(resetAccount);
				
				/** 开始调用邮件发送机制  **/
				
				
				message.setOptStatus(true);
				message.setMessage("请到账号邮箱中查收重置后的密码");
				return message;
			}else{
				message.setOptStatus(false);
				message.setMessage("该账号不存在，无法进行密码找回");
				return message;
			}
			
		}catch(Exception e){
			/**  日志记录     **/
			
			
			message.setOptStatus(false);
			message.setMessage("操作失败");
			return message;
		}		
	}
	
	/**
	 * 验证用户是否在线
	 * @param infoRequest
	 * @return
	 */
	public Message validActive(InfomationRequest infoRequest){
		return null;
	}
}
