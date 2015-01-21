package com.jing.maven.manager.entity;

public class Message {
	
	/**
	 * 操作代码
	 */
	private String optCode;

	/**
	 * 操作状态，成功true,失败false
	 */
	private Boolean optStatus;
	
	/**
	 * 返回消息
	 */
	private String message;

	public String getOptCode() {
		return optCode;
	}

	public void setOptCode(String optCode) {
		this.optCode = optCode;
	}

	public Boolean getOptStatus() {
		return optStatus;
	}

	public void setOptStatus(Boolean optStatus) {
		this.optStatus = optStatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
