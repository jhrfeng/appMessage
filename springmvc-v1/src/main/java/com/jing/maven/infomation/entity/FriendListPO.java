package com.jing.maven.infomation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jing.maven.manager.entity.IdEntity;

/**
 * 联系人列表
 * 2015-1-20 23:04:26
 * @author jinghr
 *
 */
@Entity
@Table(name = "app_friend_list")
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
	 * 我的备注
	 */
	 
	private String myRemark;

	
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

	public String getMyRemark() {
		return myRemark;
	}

	public void setMyRemark(String myRemark) {
		this.myRemark = myRemark;
	}
	
	

}
