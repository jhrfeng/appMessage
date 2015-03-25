package com.jing.maven.infomation.model;

public class ChatRequest {

	/**
	 * 发送者
	 */
	private String sendId;

	/**
	 * 接收者
	 */
	private String receiveId;
	
	/**
	 * 类型1为文字； 2为图片
	 */
	private String type;
	
	/**
	 * 消息
	 */
	private String message;

	public String getReceiveId() {
		return receiveId;
	}

	public void setReceiveId(String receiveId) {
		this.receiveId = receiveId;
	}

	public String getSendId() {
		return sendId;
	}

	public void setSendId(String sendId) {
		this.sendId = sendId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
