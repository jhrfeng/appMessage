package com.jing.maven.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.service.AccountService;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * APP登录
	 * @param account
	 * @return
	 */
	@RequestMapping("/login")
	public AccountVo accountLogin(@RequestBody AccountPO account){
		return accountService.accountLogin(account);
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	@RequestMapping("/register")
	public AccountVo accountRegister(@RequestBody AccountPO account){
		return accountService.accountRegister(account);
	}
	
	/**
	 * APP修改密码
	 * @param account
	 * @return
	 */
	@RequestMapping("/updatePwd")
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
	
	/**
	 * 验证用户是否在线
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/active")
	public Message validActive(InfomationRequest infoRequest){
		return null;
	}

}
