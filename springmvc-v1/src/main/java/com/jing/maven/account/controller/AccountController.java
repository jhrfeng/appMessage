package com.jing.maven.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.service.AccountService;
import com.jing.maven.manager.entity.Message;

public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * APP登录
	 * @param account
	 * @return
	 */
	public Message accountLogin(@RequestBody AccountPO account){
		return accountService.accountLogin(account);
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	public Message accountRegister(@RequestBody AccountPO account){
		return accountService.accountRegister(account);
	}
	
	/**
	 * APP修改密码
	 * @param account
	 * @return
	 */
	public Message updatePwd(@RequestBody AccountPO account){
		return accountService.updatePwd(account);
	}
	
	/**
	 * APP找回密码
	 * @param account
	 * @return
	 */
	public Message getAccountPwd(@RequestBody AccountPO account){
		return accountService.getAccountPwd(account);		
	}

}
