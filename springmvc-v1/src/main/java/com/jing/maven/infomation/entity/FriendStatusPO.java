package com.jing.maven.infomation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;

/**
 * 好友状态表
 * 2015-1-21 21:04:28
 * @author Jinghr
 *
 */
@Entity
@Table(name = "app_friend_status")
@JsonInclude(Include.NON_NULL)  
public class FriendStatusPO extends IdEntity {
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * 我的信息ID
	 */
	private String myinfoId;
	
	/**
	 * 我的状态 0不在线  1在线
	 */
	private String status;
	
	/**
	 * sip账号
	 */
	private String sipAccount;
	
	/**
	 * sip密码
	 */
	private String sipPwd;

    

	public String getMyinfoId() {
		return myinfoId;
	}

	public void setMyinfoId(String myinfoId) {
		this.myinfoId = myinfoId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSipAccount() {
		return sipAccount;
	}

	public void setSipAccount(String sipAccount) {
		this.sipAccount = sipAccount;
	}

	public String getSipPwd() {
		return sipPwd;
	}

	public void setSipPwd(String sipPwd) {
		this.sipPwd = sipPwd;
	}
	
	
	

}
