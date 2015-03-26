package com.jing.maven.infomation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.response.FriendRes;
import com.jing.maven.manager.entity.Message;

@JsonInclude(Include.NON_NULL)  
public class FriendListVo extends Message{
	
	private String className = "FriendListVo";

	/**
	 * 好友列表
	 */
	private List<FriendRes> friendList;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<FriendRes> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<FriendRes> friendList) {
		this.friendList = friendList;
	}
	
	
}
