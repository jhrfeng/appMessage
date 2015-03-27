package com.jing.maven.test;

import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.account.model.OtherAccountVo;
import com.jing.maven.account.model.ThridAccountVo;
import com.jing.maven.account.request.OtherAccountReq;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.infomation.request.FriendReq;
import com.jing.maven.infomation.request.InformationReq;
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
	
	public static InformationReq infomationRequest(){
		InformationReq info = new InformationReq();
		info.setTid("好友的系统账号---可选");
		info.setNickname("好友的昵称---可选");
		return info;
	}
	
	public static InformationReq infomationPO(){
		InformationReq infomation = new InformationReq();
		infomation.setTid("402884e54b2699f3014b269a0e8b0000");
		infomation.setAddr("Shanghai");
		infomation.setArea("baoshanqu");
		infomation.setBirthday("2012/12/12");
		infomation.setClassroom("02");
		infomation.setCity("shanghai");
		infomation.setGrade("9");
		infomation.setNickname("helloMonekty");
		infomation.setProvince("shanghai");
		infomation.setSchool("竹林中学");
		return infomation;
	}
	
	public static InformationReq friendListPO(){
		InformationReq InformationReq = new InformationReq();
		InformationReq.setFriendMark("JACK SOP--不为空");
		InformationReq.setTid("好友的信息ID--不为空");
		return InformationReq;
	}
	
	public static FriendReq addFriends(){
		FriendReq f = new FriendReq();
		f.setFriendid("好友的信息ID--必要");
		return f;
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
	
	public static InformationReq upHoneyname(){
		InformationReq info = new InformationReq();
		info.setTid("不用传");
		info.setNickname("昵称---必要");
		
		return info;	
	}
	
	public static InfomationPO upRemark(){
		InfomationPO info = new InfomationPO();
		info.setTid("402884e54b2699f3014b269a0e8b0000");
		info.setRemark("修改过");
		return info;
	}
	
	public static InformationReq upBirhday(){
		InformationReq info = new InformationReq();
		info.setTid("不需要");
		info.setBirthday("2012/11/21");
		return info;
	}
	
	public static InformationReq upArea(){
		InformationReq info = new InformationReq();
		info.setTid("不需要");
		info.setProvince("江苏省");
		info.setCity("南京市");
		return info;
	}
	
	public static InformationReq upSchool(){
		InformationReq info = new InformationReq();
		info.setTid("不需要");
		info.setSchool("南京长海中学");
		return info;
	}
	
	public static InformationReq upClass(){
		InformationReq info = new InformationReq();
		info.setTid("不需要");
		info.setGrade("6");
		info.setClassroom("2");
		return info;
	}
	
	public static InformationReq signature(){
		InformationReq info = new InformationReq();
		info.setTid("不需要");
		info.setSignature("填写签名信息");
		return info;
	}
	
	
	public static ThridAccountVo thridLogin(){
		ThridAccountVo account = new ThridAccountVo();
		account.setAppId("000111222");
		account.setType("1");
		account.setAccessToken("a22b34a56");
		account.setOpenId("qq123456");
		account.setSecret("ab21sfs234");
		account.setMac("00-1b-2d-4f-3a-5b-a2");
		return account;
	}
	
	public static OtherAccountReq otherAccountLogin(){
		OtherAccountReq account = new OtherAccountReq();
		account.setType("1");
		account.setAppId("qq123456");
		account.setAppToken("ab27c9b2");
		account.setMac("1b-25-c1-a5-51");
		account.setHoneyName("zhongyue");
		account.setAge("11");
		return account;
	}

}
