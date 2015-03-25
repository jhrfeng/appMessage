package com.jing.maven.common.system;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.shiro.SecurityUtils;

import com.jing.maven.account.response.OtherAccountRes;
import com.jing.maven.common.model.UserVo;

public class BaseService {
	
	public  String formatDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public  String formatyymmddDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}
	
	public  String formatUpdateDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	public  String formatTimeDate(Date date){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(date);
		return time;
	}
	
	public Boolean authLogin(){
		if(SecurityUtils.getSubject().isAuthenticated())
			return true;
		else
			return false;
	}
	
	public String inputId(){
		try{			
			UserVo userVo = AuthorityHelper.getUser();
			return userVo.getInfoId();
		}catch(Exception e){
			return null;
		}
	}
	
	public OtherAccountRes friendStatusConvertOtherAccountRes(){
		
	}
}
