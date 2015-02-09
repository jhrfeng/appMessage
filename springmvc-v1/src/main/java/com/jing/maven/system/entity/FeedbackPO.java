package com.jing.maven.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;

/**
 * 联系人列表
 * 2015-1-20 23:04:26
 * @author jinghr
 *
 */
@Entity
@Table(name = "app_feeback")
@JsonInclude(Include.NON_NULL)  
public class FeedbackPO extends IdEntity{
		
   private static final long serialVersionUID = 2433461464054606867L;
		

	/**
	 * 问题反馈
	 */
	private String question;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 个人信息ID
	 */
	private String infoId;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getInfoId() {
		return infoId;
	}

	public void setInfoId(String infoId) {
		this.infoId = infoId;
	}
	
	
	
}
