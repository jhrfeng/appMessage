package com.jing.maven.infomation.model;

import com.jing.maven.infomation.response.InformationRes;
import com.jing.maven.manager.entity.Message;

/**
 * 返回大对象
 * @author Jinghr
 *
 */
public class InformationVo extends Message{
	
	private String className = "informationVo";
	
	/**
	 * person信息对象
	 */
	private InformationRes information;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public InformationRes getInformation() {
		return information;
	}

	public void setInformation(InformationRes information) {
		this.information = information;
	}
	
	

}
