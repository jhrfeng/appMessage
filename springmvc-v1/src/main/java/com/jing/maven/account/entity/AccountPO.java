package com.jing.maven.account.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;

/**
 * 账号信息实体
 * 2015-1-20 22:33:08
 * @author jinghr
 * 
 */
@Entity
@Table(name = "app_account")
@JsonInclude(Include.NON_NULL)  
public class AccountPO extends IdEntity {
	
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 设备mac地址
	 */
	private String mac;
	
	
	/**
	 * 个人信息外键
	 */
	private String infoid;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 修改时间
	 */
	private String updateDate;
	
	/**
	 * 修改人
	 */
	private String updateid;
	

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getInfoid() {
		return infoid;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
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

	public String getUpdateid() {
		return updateid;
	}

	public void setUpdateid(String updateid) {
		this.updateid = updateid;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	
	
}
