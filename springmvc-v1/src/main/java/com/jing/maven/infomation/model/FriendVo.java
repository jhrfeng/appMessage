package com.jing.maven.infomation.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.manager.entity.Message;

@JsonInclude(Include.NON_NULL)  
public class FriendVo extends Message{
	
	/**
	 * 好友列表
	 */
	private List<FriendListPO> friendList;
	
	/**
	 * 个人信息列表
	 */
	private List<InfomationPO> infomationList;

	public List<FriendListPO> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<FriendListPO> friendList) {
		this.friendList = friendList;
	}

	public List<InfomationPO> getInfomationList() {
		return infomationList;
	}

	public void setInfomationList(List<InfomationPO> infomationList) {
		this.infomationList = infomationList;
	}
	
	
	

}
