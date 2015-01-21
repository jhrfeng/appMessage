package com.jing.maven.account.controller;

import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.manager.entity.Message;

public class AccountController {
	
	/**
	 * APP登录
	 * @param account
	 * @return
	 */
	public Message accountLogin(@RequestBody AccountPO account){
		return null;
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	public Message accountRegister(@RequestBody AccountPO account){
		return null;
	}
	
	/**
	 * APP修改密码
	 * @param account
	 * @return
	 */
	public Message updatePwd(@RequestBody AccountPO account){
		return null;
	}
	
	/**
	 * APP找回密码
	 * @param account
	 * @return
	 */
	public Message getAccountPwd(@RequestBody AccountPO account){
		return null;		
	}

}
