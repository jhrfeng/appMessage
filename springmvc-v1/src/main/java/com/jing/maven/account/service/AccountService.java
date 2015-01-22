package com.jing.maven.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jing.maven.account.dao.AccountDao;
import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.common.util.EncryptUtils;
import com.jing.maven.common.util.MathUtils;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.manager.entity.Message;

@Service
public class AccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private InfomationDao infomationDao;

	/**
	 * APP登录
	 * @param account
	 * @return
	 */
	public Message accountLogin(AccountPO account){
		
		Message message = new Message();
		AccountPO loginAccount = accountDao.findByAccount(account.getAccount());
		if(null == loginAccount){
			message.setOptStatus(false);
			message.setMessage("不存在该账号");
		}else{
			String pwd = EncryptUtils.encryptMD5(account.getPassword()+"");
			if(pwd.equals(loginAccount.getPassword())){
				message.setOptStatus(true);
				message.setMessage("登录成功");
			}else{
				message.setOptStatus(false);
				message.setMessage("密码不正确");
			}	
		}
		
		return message;
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	public Message accountRegister(AccountPO account){
		
		return null;
	}
	
	/**
	 * APP修改密码
	 * @param account
	 * @return
	 */
	public Message updatePwd(AccountPO account){
		Message message = new Message();
		try{
			AccountPO updateAccount = accountDao.findOne(""); //获取当前登录用户id
			updateAccount.setPassword(EncryptUtils.encryptMD5(account.getPassword()));
			updateAccount.setUpdateDate("2012/12/12");
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
}
