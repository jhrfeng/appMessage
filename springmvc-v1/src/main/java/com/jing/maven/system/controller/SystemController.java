package com.jing.maven.system.controller;

import java.io.FileInputStream;
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

import com.jing.maven.common.model.UploadedFile;
import com.jing.maven.common.system.BaseController;
import com.jing.maven.common.system.FileValidator;
import com.jing.maven.common.util.PropertyUtil;
import com.jing.maven.manager.entity.Message;
import com.jing.maven.system.entity.FeedbackPO;
import com.jing.maven.system.model.CompanyInfo;
import com.jing.maven.system.service.SystemService;


@Controller
@RequestMapping("system")
public class SystemController extends BaseController{
	
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
		if(authLogin()){
			return systemService.feedback(feedback);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 关于我们
	 * @return
	 */
	@RequestMapping("/about")
	@ResponseBody
	public CompanyInfo about(){
		if(authLogin()){
			return systemService.about();
		}else{
			CompanyInfo info = new CompanyInfo();
			info.setOptStatus(false);
			info.setOptCode("500");
			info.setMessage("没有权限访问");
			return info;
		}
		
	}
	
	@RequestMapping("/headUpload")  
	@ResponseBody
	public Message fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,BindingResult result) { 
		if(authLogin()){
			return systemService.fileUpload(uploadedFile, result);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
 }
	
	@RequestMapping(value = "/download")
	@ResponseBody
	public void imgInfomation( HttpServletRequest request, HttpServletResponse response)
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
		//	String webPath = root+fileUrl ;	// 相当于当前web应用的path
		for(int i=0; i<5; i++){

			InputStream in = new FileInputStream("E:\\shirodemo.log");
	
			OutputStream out = response.getOutputStream();
		
			int len;
			byte[] buffer = new byte[1024];
			while((len=in.read(buffer))!=-1){
				out.write(buffer, 0, len);
			}
				
			out.close();
			in.close();	
		}
		}catch(Exception e){
			e.printStackTrace();
			writer.print("该下载文件不存在");			
		}		
	}
	
	@RequestMapping(value = "/downloadHeadImg")
	@ResponseBody
	public void downloadHeadImg(@RequestBody String fileUrl, HttpServletRequest request, HttpServletResponse response)
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
			String webPath = root+fileUrl ;	// 相当于当前web应用的path
		
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
