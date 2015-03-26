package com.jing.maven.infomation.response;

public class FriendRes {

	private String className = "FriendRes";

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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
