package com.jing.maven.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.account.service.AccountService;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

@Controller
@RequestMapping("account")
public class ThridAccountController {
	
	@Autowired
	private AccountService accountService;
	
	/**
	 * 第三方APP登录
	 * @param account
	 * @return
	 */
	@RequestMapping("/thridlogin")
	public AccountVo accountLogin(@RequestBody ThridAccountVo account){
		return null;
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
	


}
