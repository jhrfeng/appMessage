package com.jing.maven.logj.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jing.maven.manager.entity.IdEntity;

/**
 * 好友状态表
 * 2015-1-21 21:04:28
 * @author Jinghr
 *
 */
@Entity
@Table(name = "app_logj")
public class LogjPO extends IdEntity {
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * 操作Ip
	 */
	private String ip;
	
	/**
	 * 操作人
	 */
	private String inputid;
	
	/**
	 * 操作日期
	 */
	private String inputDate;
	
	/**
	 * 操作记录
	 */
	private String remark;

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInputid() {
		return inputid;
	}

	public void setInputid(String inputid) {
		this.inputid = inputid;
	}

	public String getInputDate() {
		return inputDate;
	}

	public void setInputDate(String inputDate) {
		this.inputDate = inputDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}
