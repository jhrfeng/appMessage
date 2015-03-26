package com.jing.maven.common.system;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.shiro.SecurityUtils;

import com.jing.maven.account.response.OtherAccountRes;
import com.jing.maven.common.model.UserVo;
import com.jing.maven.infomation.entity.FriendPO;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.response.FriendRes;
import com.jing.maven.infomation.response.InformationRes;

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
	
	public OtherAccountRes friendStatusConvertOtherAccountRes(FriendStatusPO friendStatus){
		if(null==friendStatus) return null;
		OtherAccountRes account = new OtherAccountRes();
		account.setMyinfoId(friendStatus.getMyinfoId());
		account.setSipAccount(friendStatus.getSipAccount());
		account.setSipPwd(friendStatus.getSipPwd());
		return account;
	}
	
	public InformationRes infomationPOConvertRes(InfomationPO infoPO){
		if(null==infoPO) return null;
		InformationRes res = new InformationRes();
		res.setAddr(infoPO.getAddr());
		res.setAge(infoPO.getAge());
		res.setArea(infoPO.getArea());
		res.setBirthday(infoPO.getBirthday());
		res.setCity(infoPO.getCity());
		res.setClassroom(infoPO.getClassroom());
		res.setGrade(infoPO.getGrade());
		res.setNickname(infoPO.getNickname());
		res.setProvince(infoPO.getProvince());
		res.setSchool(infoPO.getSchool());
		res.setSex(infoPO.getSex());
		res.setSignature(infoPO.getSignature());
		res.setTid(infoPO.getTid());
		return res;
	}
	
	public FriendRes friendPOConverRes(FriendPO friend){
		if(null==friend) return null;
		FriendRes res = new FriendRes();
		res.setFdNickname(friend.getFdNickname());
		res.setFdRemark(friend.getFdRemark());
		res.setFdSignature(friend.getFdSignature());
		res.setFdSipAccount(friend.getFdSipAccount());
		res.setFriendid(friend.getFriendid());
		return res;
	}
	
	public List<FriendRes> friendPOConverRes(List<FriendPO> friendList){
		List<FriendRes> resList = new ArrayList<FriendRes>();
		if(null!=friendList){
			for(FriendPO friend : friendList){
				resList.add(friendPOConverRes(friend));
			}
			return resList;
		}
		return resList;
	}
}
