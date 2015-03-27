package com.jing.maven.account.request;

public class OtherAccountReq {
	
	private String className = "OtherAccountReq";
	
	/**
	 * type 1为QQ第三方登录； 2为微信第三方登录；
	 */
	private String type;
	
	/**
	 * QQ第三方主键
	 */
	private String appId;
	
	/**
	 * QQ第三方密钥
	 */
	private String appToken;
	
	
	/**
	 * 昵称
	 */
	private String honeyName;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 年龄
	 */
	private String age;

	/**
	 * 生日
	 */
	private String birthday;
	
	/**
	 * mac地址
	 */
	private String mac;
	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}


	public String getHoneyName() {
		return honeyName;
	}

	public void setHoneyName(String honeyName) {
		this.honeyName = honeyName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
	

}
