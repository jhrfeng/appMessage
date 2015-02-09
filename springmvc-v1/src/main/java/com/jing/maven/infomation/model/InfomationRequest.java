package com.jing.maven.infomation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)  
public class InfomationRequest {
	
	/**
	 * 请求id
	 */
	private String requestId;
	
	/**
	 * 请求名称
	 */
	private String requestName;
	
	/**
	 * 请求标示符
	 */
	private String identify;
	
	/**
	 * 请求类别
	 */
	private String type;
	
	/**
	 * 请求当前页
	 */
	private String currentPages;
	
	/**
	 * 请求分页数目
	 */
	private String pageNumber;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCurrentPages() {
		return currentPages;
	}

	public void setCurrentPages(String currentPages) {
		this.currentPages = currentPages;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public String getRequestName() {
		return requestName;
	}

	public void setRequestName(String requestName) {
		this.requestName = requestName;
	}
	
	

}
