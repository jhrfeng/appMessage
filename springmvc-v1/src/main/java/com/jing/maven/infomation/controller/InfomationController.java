package com.jing.maven.infomation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

public class InfomationController {
	
	/**
	 * 个人好友信息查看接口
	 * @param infoRequest
	 * @return
	 */
	public InfomationPO showInfo(@RequestBody InfomationRequest infoRequest){
		return null;
	}
	
	/**
	 * 个人好友信息修改接口
	 * @param infomation
	 * @return
	 */
	public Message updateInfo(@RequestBody InfomationPO infomation){
		return null;
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	public Message updateRemark(@RequestBody FriendListPO friend){
		return null;
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	public List<FriendVo> loadFriendList(@RequestBody InfomationRequest infoRequest){
		return null;
	}
	
	/**
	 * 好友推荐
	 * @return
	 */
	public List<InfomationPO> introduceFriend(){
		return null;
	}
	
	/**
	 * 好友查找
	 * @param infoRequest
	 * @return
	 */
	public InfomationPO searchFriend(@RequestBody InfomationRequest infoRequest){
		return null;
	}
	
	/**
	 * 好友验证
	 * @return
	 */
	public Message validFriend(@RequestBody InfomationPO infomation){
		return null;
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	public Message delFriend(@RequestBody InfomationRequest infoRequest){
		return null;
	}

}
