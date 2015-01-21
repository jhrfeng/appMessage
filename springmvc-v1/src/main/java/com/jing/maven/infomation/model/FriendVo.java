package com.jing.maven.infomation.model;

import java.util.List;

import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.manager.entity.Message;

public class FriendVo extends Message{
	
	/**
	 * 好友列表
	 */
	private List<FriendListPO> friendList;

	public List<FriendListPO> getFriendList() {
		return friendList;
	}

	public void setFriendList(List<FriendListPO> friendList) {
		this.friendList = friendList;
	}
	
	
	

}
