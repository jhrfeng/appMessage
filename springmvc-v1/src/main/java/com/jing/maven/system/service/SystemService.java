package com.jing.maven.system.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.jing.maven.common.model.UploadedFile;
import com.jing.maven.common.system.BaseService;
import com.jing.maven.common.system.FileValidator;
import com.jing.maven.common.util.PropertyUtil;
import com.jing.maven.manager.entity.Message;
import com.jing.maven.system.dao.FileUploadDao;
import com.jing.maven.system.dao.SystemDao;
import com.jing.maven.system.entity.FeedbackPO;
import com.jing.maven.system.entity.FileUploadPO;
import com.jing.maven.system.model.CompanyInfo;

@Service
public class SystemService extends BaseService{
	
	@Autowired
	private SystemDao systemDao;
	
	@Autowired  
	FileValidator fileValidator;
	
	@Autowired
	private FileUploadDao fileUploadDao;

	/**
	 * 问题反馈
	 * @param feedback
	 * @return
	 */
	public Message feedback(@RequestBody FeedbackPO feedback){
		Message message = new Message();
		try{
			if(null!=feedback && null!=feedback.getQuestion()  &&!"".equals(feedback.getQuestion())){
				feedback.setCreateDate(formatUpdateDate(new Date()));
				feedback.setInfoId(inputId());
				systemDao.save(feedback);
				message.setOptStatus(true);
				message.setMessage("感谢反馈");
				return message;
			}else{
				message.setOptStatus(false);
				message.setMessage("内容不能为空");
				return message;
			}
		}catch(Exception e){
			message.setOptStatus(false);
			message.setMessage("反馈失败");
			return message;
		}
		
	}
	
	/**
	 * 关于我们
	 * @return
	 */
	public CompanyInfo about(){
		return new CompanyInfo();
	}
	
	/**
	 * 文件上传
	 * @param uploadFile
	 */
	public Message fileUpload(UploadedFile uploadedFile,BindingResult result){
		InputStream inputStream = null;  
		OutputStream outputStream = null; 
		FileUploadPO fileUpload = new FileUploadPO();
  
		MultipartFile file = uploadedFile.getFile();  
		fileValidator.validate(uploadedFile, result);  

		if (result.hasErrors()) {  
		 	return new Message(false, "上传失败");  
		}  
  
		try {  
			inputStream = file.getInputStream();  
			String uploadRoot = PropertyUtil.getValue("resourceUploadPath")+"";
			
			String fileName = file.getOriginalFilename();  
			fileUpload.setSaveType("1"); //上传类型为头像
			fileUpload.setFileName(fileName);
			fileUpload.setFileSize(file.getSize()+"");
			fileUpload.setFileType(file.getContentType());
			fileUpload.setFileUrl(uploadRoot+fileName);
			fileUpload.setInfoid(inputId());
			fileUpload.setCreateDate(formatUpdateDate(new Date()));
			fileUploadDao.save(fileUpload);
	  
			File newFile = new File(uploadRoot+fileName);  
			if (!newFile.exists()) {  
				newFile.createNewFile();  
			}  
			outputStream = new FileOutputStream(newFile);  
			int read = 0;  
			byte[] bytes = new byte[1024];  
  
			while ((read = inputStream.read(bytes)) != -1) {  
				outputStream.write(bytes, 0, read);  
			}  
			inputStream.close();
			outputStream.close();
			return new Message(true, "上传成功"); 
			
		} catch (IOException e) {  
			e.printStackTrace(); 
			return new Message(false, "上传失败");  
		}  	 
	}
}
