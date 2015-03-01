package com.jing.maven;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.system.entity.FeedbackPO;
import com.jing.maven.system.model.CompanyInfo;

public class DataSource {
	
	public static AccountPO createAccountPO(){
		AccountPO account = new AccountPO();
		account.setAccount("");
		account.setPassword("");
		return account;
	}
	
	public static FeedbackPO feedbackPO(){
		FeedbackPO feedbackPO = new FeedbackPO();
	//	feedbackPO.setCreateDate("2012/12/12");
		feedbackPO.setQuestion("我想知道，退出怎么退出啊？退出按钮在哪里呢？");
		return feedbackPO;
	}
	
	public static CompanyInfo companyInfo(){
		CompanyInfo info = new CompanyInfo();
		info.setAboutUs("我是是一个致力于教育事业的团队，支持我们！");
		info.setOptStatus(true);
		info.setMessage("请求成功");
		return info;
	}
	
	public static InfomationRequest infomationRequest(){
		InfomationRequest info = new InfomationRequest();
		info.setRequestId("402884e54b2699f3014b269a0e8b0000");
		info.setRequestName("hellowkitty");
		return info;
	}
	
	public static InfomationPO infomationPO(){
		InfomationPO infomation = new InfomationPO();
		infomation.setTid("402884e54b2699f3014b269a0e8b0000");
		infomation.setAddr("Shanghai");
		infomation.setAge("11");
		infomation.setArea("baoshanqu");
		infomation.setBirthday("2012/12/12");
		infomation.setClassroom("02");
		infomation.setCity("shanghai");
		infomation.setEmail("1059731125@qq.com");
		infomation.setGrade("9");
		infomation.setHoneyName("hellowMoneky");
		infomation.setMobile("1363221234");
		infomation.setProvince("shanghai");
		infomation.setQq("1059731125");
		infomation.setRemark("呵呵");
		infomation.setSchool("竹林中学");
		return infomation;
	}
	
	public static FriendListPO friendListPO(){
		FriendListPO friendList = new FriendListPO();
		friendList.setTid("402884e54b26b90d014b26b925010000");
		friendList.setFriendId("402884e54b2698db014b2698fb510000");
		friendList.setFriendRemark("张丽丽");
		return friendList;
	}
	
	public static InfomationRequest infomationRequestId(){
		InfomationRequest infomation = new InfomationRequest();
		infomation.setRequestId("402884e54b2699f3014b269a0e8b0000");
		return infomation;
	}
	
	public static FriendListPO addFriend(){
		FriendListPO friend = new FriendListPO();
		friend.setFriendId("402884e54b2699f3014b269a0e8b0000");
		friend.setMyId("402884e54b2698db014b2698fb510000");
		return friend;
	}
	
	public static InfomationPO upHoneyname(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setHoneyName("小乖乖");
		return info;	
	}
	
	public static InfomationPO upRemark(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setRemark("修改过");
		return info;
	}
	
	public static InfomationPO upBirhday(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setBirthday("2012/11/21");
		return info;
	}
	
	public static InfomationPO upArea(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setProvince("江苏省");
		info.setCity("南京市");
		return info;
	}
	
	public static InfomationPO upSchool(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setSchool("南京长海中学");
		return info;
	}
	
	public static InfomationPO upClass(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setGrade("6");
		info.setClassroom("2");
		return info;
	}
	
	public static ThridAccountVo thridLogin(){
		ThridAccountVo account = new ThridAccountVo();
		account.setAppId("000111222");
		account.setType("1");
		account.setAccessToken("a22b34a56");
		return account;
	}

}
