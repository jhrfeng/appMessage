package com.jing.maven.account.entity;

import javax.persistence.GenerationType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@JsonInclude(Include.NON_NULL) 
@Entity
@Table(name = "app_thrid_account")
public class ThridAccountPO extends  IdEntity{
	
	private static final long serialVersionUID = 2433461464054606867L;

	/**
	 * qq的openId
	 */
	private String openId;
	
	/**
	 * qq的密钥
	 */
	private String accessToken;
	
	/**
	 * 微信第三方id
	 */
	private String appId;
	
	/**
	 * 微信第三方密钥
	 */
	private String secret;
	
	/**
	 * 根据第三方自动生成账号
	 */
	private String autoAccount;
	
	/**
	 * 根据第三方自动生成密码
	 */
	private String autoPassword;
	
	/**
	 * mac地址
	 */
	private String mac;
	
	/**
	 * 生成时间
	 */
	private String createDate;
	
	/**
	 * 更新时间
	 */
	private String updateDate;
	
	/**
	 * 个人信息外键
	 */
	private String infoid;
	
	@SequenceGenerator(name = "generator", sequenceName = "CRM_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	public String getAutoAccount() {
		return autoAccount;
	}

	public void setAutoAccount(String autoAccount) {
		this.autoAccount = autoAccount;
	}

	public String getAutoPassword() {
		return autoPassword;
	}

	public void setAutoPassword(String autoPassword) {
		this.autoPassword = autoPassword;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getInfoid() {
		return infoid;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	

}
