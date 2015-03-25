package com.jing.maven.infomation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;


@Entity
@Table(name = "app_chat_history")
@JsonInclude(Include.NON_NULL)
public class ChatHistoryPO extends IdEntity{
	
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * l聊天id
	 */
	private String chatId;
	
	/**
	 * 内容所属者Id
	 */
	private String ascriptionId;
	
	/**
	 * 聊天时间
	 */
	private String chatTime;
	
	/**
	 * 聊天内容
	 */
	private String message;
	
    /**
     * 存档路径
     */
	private String url;
	
	/**
	 * 类型1为文字； 2为图片
	 */
	private String type;
	
	/**
	 * 生成日期
	 */
	private String inputDate;

	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	public String getAscriptionId() {
		return ascriptionId;
	}

	public void setAscriptionId(String ascriptionId) {
		this.ascriptionId = ascriptionId;
	}

	public String getChatTime() {
		return chatTime;
	}

	public void setChatTime(String chatTime) {
		this.chatTime = chatTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}
	
	
	
	

}
