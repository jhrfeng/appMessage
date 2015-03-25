package com.jing.maven.infomation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.manager.entity.IdEntity;

/**
 * 联系人列表
 * 2015-1-20 23:04:26
 * @author jinghr
 *
 */
@Entity
@Table(name = "app_friend_list")
@JsonInclude(Include.NON_NULL)  
public class FriendListPO extends IdEntity {
	
	private static final long serialVersionUID = 2433461464054606867L;
	
	/* 我的id与好友id进行联合主键  */
	
	/**
	 * 我的id
	 */
	private String myId;
	
	/**
	 * 好友id
	 */
	private String friendId;

	/**
	 * 好友备注
	 */
	private String friendRemark;
	
	/**
	 * 0黑名单，1好友，2验证，3拒绝, 4删除
	 */
	private String status;

	/**
	 * 好友昵称    ----》删除掉，从个人信息中关联过去
	 */
	 
	private String nickname;
	
	/**
	 * 好友sip账号   ---》删除掉，从个人信息中关联回去
	 */
	private String friendSip;

	
	public String getMyId() {
		return myId;
	}

	public void setMyId(String myId) {
		this.myId = myId;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public String getFriendRemark() {
		return friendRemark;
	}

	public void setFriendRemark(String friendRemark) {
		this.friendRemark = friendRemark;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getFriendSip() {
		return friendSip;
	}

	public void setFriendSip(String friendSip) {
		this.friendSip = friendSip;
	}
	
	

}
