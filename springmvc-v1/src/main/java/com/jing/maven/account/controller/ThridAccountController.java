package com.jing.maven.account.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.model.AccountVo;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.account.service.ThridAccountService;
import com.jing.maven.manager.entity.Message;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

@Controller
@RequestMapping("accountsys")
public class ThridAccountController {
	
	@Autowired
	private ThridAccountService thridAccountService;
	
	/**
	 * 第三方APP登录
	 * @param account
	 * @return
	 */
	@RequestMapping("/thridlogin")
	public AccountVo accountLogin(@RequestBody ThridAccountVo account,HttpSession session, HttpServletRequest request){
		AccountVo result = new AccountVo();
		Subject currentUser = SecurityUtils.getSubject();
		UsernamePasswordToken token;
		if("1".equals(account.getType())){			
			token = new UsernamePasswordToken(account.getOpenId().trim(), "1"); //qq
		}else{
			token = new UsernamePasswordToken(account.getAppId().trim(), "2"); //weixin
		}
		token.setRememberMe(true);
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			result.setOptStatus(false);
			result.setMessage("登录失败");
			return result;
		}
		
		if(currentUser.isAuthenticated()){
			result = thridAccountService.accountLogin(account);
			session.setAttribute( "sysUserInfo", result.getFriendStatus());
			
		}else{
			result.setOptStatus(false);
			result.setMessage("登录失败");
		}
		return result;
	}
	
	/**
	 * 退出登录
	 * 
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/logout")
	public Message logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
		Message message = new Message();
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		try {
			  session.getId();
			  currentUser.logout();
			  Cookie cookies[] = request.getCookies();
			  for (int i = 0; cookies != null && i < cookies.length; i++) {
			   Cookie cookie = cookies[i];
			   cookie.setMaxAge(0);
			   response.addCookie(cookie);
			  }
			  message.setOptStatus(true);
			  message.setMessage("注销成功");
			  return message;

		} catch (AuthenticationException e) {
			message.setOptStatus(false);
			message.setMessage("注销失败");
			e.printStackTrace();
			return message;
		}
		
	}
	
	/**
	 * APP注册及自动生成个人信息表
	 * @param account
	 * @return
	 */
	@RequestMapping("/register")
	public AccountVo accountRegister(@RequestBody AccountPO account){
		//return accountService.accountRegister(account);
		return null;
	}
	


}
