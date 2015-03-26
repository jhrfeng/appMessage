package com.jing.maven.infomation.model;

import java.util.List;

import com.jing.maven.infomation.response.InformationRes;
import com.jing.maven.manager.entity.Message;

public class SearchFriendVo extends Message{

	private String className = "SearchFriendVo";
	
	/**
	 * 匹配到的好友信息
	 */
	private List<InformationRes> searchFriendList;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public List<InformationRes> getSearchFriendList() {
		return searchFriendList;
	}

	public void setSearchFriendList(List<InformationRes> searchFriendList) {
		this.searchFriendList = searchFriendList;
	}
	
	
}
