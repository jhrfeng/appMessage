package com.jing.maven.infomation.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import org.hibernate.annotations.Subselect;


@Entity
@Subselect("select f.myid, f.friendid , i.nickname as fdnickname, f.friendremark, o.sipaccount as fdSipAccount, i.signature as fdSignature, f.status from app_friend_list f left join app_other_account o on f.friendid = o.infoid left join app_infomation i on f.friendid = i.tid ")
public class FriendPO implements Serializable {
	
	private static final long serialVersionUID = -4504826294723063426L;
	
	private String myid;
	
	/**
	 * 好友id
	 */
	private String friendid;
	
	/**
	 * 好友昵称
	 */
	private String fdNickname;
	
	/**
	 * 好友签名状态
	 */
	private String fdSignature;
	
	/**
	 * 你对该好友的进行修改的备注
	 */
	private String fdRemark;
	
	/**
	 * 好友sip账号
	 */
	private String fdSipAccount;
	
	/**
	 * 好友状态
	 */
	private String status;

	public String getFriendid() {
		return friendid;
	}

	public void setFriendid(String friendid) {
		this.friendid = friendid;
	}

	public String getFdNickname() {
		return fdNickname;
	}

	public void setFdNickname(String fdNickname) {
		this.fdNickname = fdNickname;
	}

	public String getFdSignature() {
		return fdSignature;
	}

	public void setFdSignature(String fdSignature) {
		this.fdSignature = fdSignature;
	}

	public String getFdRemark() {
		return fdRemark;
	}

	public void setFdRemark(String fdRemark) {
		this.fdRemark = fdRemark;
	}

	public String getFdSipAccount() {
		return fdSipAccount;
	}

	public void setFdSipAccount(String fdSipAccount) {
		this.fdSipAccount = fdSipAccount;
	}

	public String getMyid() {
		return myid;
	}

	public void setMyid(String myid) {
		this.myid = myid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	


}
