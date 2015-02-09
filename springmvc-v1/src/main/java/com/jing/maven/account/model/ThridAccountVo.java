package com.jing.maven.account.model;

public class ThridAccountVo {
	
	/**
	 * type 1为QQ第三方登录； 2为微信第三方登录；
	 */
	private String type;
	
	/**
	 * QQ第三方主键
	 */
	private String openId;
	
	/**
	 * QQ第三方密钥
	 */
	private String AccessToken;
	
	/**
	 * 微信第三方登录主键
	 */
	private String appId;
	
	/**
	 * 微信第三方密钥
	 */
	private String secret;
	
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
	 * 省 无法使用，与本数据库参数表无法匹配
	 */
	private String province;

	/**
	 * 城市 无法使用，与本数据库参数表无法匹配
	 */
	private String city;
	
	/**
	 * 地区 无法使用，与本数据库参数表无法匹配
	 */
	private String area;
	
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

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getAccessToken() {
		return AccessToken;
	}

	public void setAccessToken(String accessToken) {
		AccessToken = accessToken;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	

}
