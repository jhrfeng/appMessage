package com.jing.maven.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.jing.maven.common.model.UploadedFile;
import com.jing.maven.common.system.FileValidator;
import com.jing.maven.common.util.PropertyUtil;
import com.jing.maven.manager.entity.Message;
import com.jing.maven.system.entity.FeedbackPO;
import com.jing.maven.system.model.CompanyInfo;
import com.jing.maven.system.service.SystemService;


@Controller
@RequestMapping("system")
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	 @Autowired  
	 FileValidator fileValidator;
	
	/**
	 * 问题反馈
	 * @param feedback
	 * @return
	 */
	@RequestMapping("/feedback")
	@ResponseBody
	public Message feedback(@RequestBody FeedbackPO feedback){
		
		return systemService.feedback(feedback);
	}
	
	/**
	 * 关于我们
	 * @return
	 */
	@RequestMapping("/about")
	@ResponseBody
	public CompanyInfo about(){
		return systemService.about();
	}
	
	@RequestMapping("/fileUpload")  
	@ResponseBody
	public Message fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,BindingResult result) {  
		InputStream inputStream = null;  
		OutputStream outputStream = null;  
  
		MultipartFile file = uploadedFile.getFile();  
		fileValidator.validate(uploadedFile, result);  
  
		String fileName = file.getOriginalFilename();  
  
		if (result.hasErrors()) {  
		 	return new Message(false, "上传失败");  
		}  
  
		try {  
			inputStream = file.getInputStream();  
  
			File newFile = new File("/usr/local/" + fileName);  
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
	
	@RequestMapping(value = "/download")
	@ResponseBody
	public void imgInfomation(String fileUrl, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 			
	{
		PrintWriter writer = null; //= new PrintWriter();
		try{
			//根目录
			String root = PropertyUtil.getValue("resourceUploadPath")+"";
			String downloadFileName = "shirodemo.log";
			// 通知浏览器以下载的方式读取资源
			response.setHeader("content-disposition", "attachment;filename="+downloadFileName);
			
			// 读取图片数据  发给ie浏览器
			String webPath = root+"shirodemo.log" ;	// 相当于当前web应用的path
		
			InputStream in = new FileInputStream(webPath);
	
			OutputStream out = response.getOutputStream();
		
			int len;
			byte[] buffer = new byte[1024];
			while((len=in.read(buffer))!=-1){
				out.write(buffer, 0, len);
			}
				
			out.close();
			in.close();
		}catch(Exception e){
			e.printStackTrace();
			writer.print("该下载文件不存在");			
		}		
	}

}
