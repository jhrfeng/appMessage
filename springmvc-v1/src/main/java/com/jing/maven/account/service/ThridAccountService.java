package com.jing.maven.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.maven.account.dao.ThridAccountDao;
import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.entity.ThridAccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.model.ThridAccountVo;

public class ThridAccountService {
	
	@Autowired
	private ThridAccountDao thridAccountDao;
	
	
	/**
	 * 第三方登录
	 * @param account
	 * @return
	 */
	public AccountVo accountLogin(ThridAccountVo account){
				
		if("1".equals(account.getType())){// 1为QQ
			
			
		}else if("2".equals(account.getType())){ //为微信
			
		}
		
		//判断是否已存在，存在则为登录
		
		//否则注册生成账号
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
