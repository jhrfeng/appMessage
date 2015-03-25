package com.jing.maven.system.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;

/**
 * 文件上传保存记录
 * @author jinghr
 *
 */
@Entity
@Table(name = "app_fileupload")
@JsonInclude(Include.NON_NULL)  
public class FileUploadPO extends IdEntity{
	
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * 文件名称
	 */
	private String fileName;
	
	/**
	 * 文件类型
	 */
	private String fileType;
	
	/**
	 * 文件大小
	 */
	private String fileSize;
	
	/**
	 * 文件保存路径
	 */
	private String fileUrl;
	
	/**
	 * 用户id
	 */
	private String infoid;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 修改时间
	 */
	private String modifyDate;
	
	/**
	 * 储存类型 1头像 ， 2视频截图
	 */
	private String saveType;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getInfoid() {
		return infoid;
	}

	public void setInfoid(String infoid) {
		this.infoid = infoid;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getSaveType() {
		return saveType;
	}

	public void setSaveType(String saveType) {
		this.saveType = saveType;
	}
	

}
