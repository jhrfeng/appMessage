package com.jing.maven.account.response;

public class OtherAccountRes {
	
	private String className = "OtherAccountRes";
	
	/**
	 * 我的信息ID
	 */
	private String myinfoId;
	
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

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	

}
