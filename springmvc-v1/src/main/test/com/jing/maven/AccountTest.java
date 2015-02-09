package com.jing.maven;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sun.jdbc.odbc.ee.DataSource;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.service.AccountService;
import com.jing.maven.infomation.dao.InfomationDao;


@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:conf/applicationContext.xml" })
public class AccountTest extends DataSource{

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private InfomationDao infomationDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		
	}
	

	
	/**
	 * APP登录
	 * @param account
	 * @return
	 */
	//@Test
	public void accountLogin(){
		AccountPO account = new AccountPO();
		account.setAccount("1059731125@qq.com");
		account.setPassword("123456");
		
		accountService.accountLogin(account);		
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	//@Test
	public void accountRegister(){
		AccountPO account = new AccountPO();
		account.setAccount("1059731125@qq.com");
		account.setPassword("123456");
		
		accountService.accountRegister(account);
		
		
	}
	
	/**
	 * APP修改密码
	 * @param account
	 * @return
	 */
	//@Test
	public void updatePwd(){
		AccountPO account = new AccountPO();
		account.setTid("402884e54b2699f3014b269a1ec50001");
		account.setAccount("1234556@qq.com");
		account.setPassword("654321");
		
		accountService.updatePwd(account);
	
	}
	
	/**
	 * APP找回密码
	 * @param account
	 * @return
	 */
	//@Test
	public void getAccountPwd(){
		
	}
	
	
	
}
