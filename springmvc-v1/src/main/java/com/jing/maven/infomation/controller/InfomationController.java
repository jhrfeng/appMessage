package com.jing.maven.infomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.infomation.service.InfomationService;
import com.jing.maven.manager.entity.Message;

public class InfomationController {
	
	@Autowired
	private InfomationService infoService;
	
	/**
	 * 个人好友信息查看接口
	 * @param infoRequest
	 * @return
	 */
	public InfomationPO showInfo(@RequestBody InfomationRequest infoRequest){
		
		return infoService.showInfo(infoRequest);
	}
	
	/**
	 * 个人好友信息修改接口
	 * @param infomation
	 * @return
	 */
	public Message updateInfo(@RequestBody InfomationPO infomation){
		return infoService.updateInfo(infomation);
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	public Message updateRemark(@RequestBody FriendListPO friend){
		return infoService.updateRemark(friend);
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	public FriendVo loadFriendList(@RequestBody InfomationRequest infoRequest){
		return infoService.loadFriendList(infoRequest);
	}
	
	/**
	 * 好友推荐
	 * @return
	 */
	public List<InfomationPO> introduceFriend(){
		return infoService.introduceFriend();
	}
	
	/**
	 * 好友查找
	 * @param infoRequest
	 * @return
	 */
	public FriendVo searchFriend(@RequestBody InfomationRequest infoRequest){
		return infoService.searchFriend(infoRequest);
	}
	
	/**
	 * 好友新增
	 * @param infomationRequest
	 * @return
	 */
	public Message addFriend(@RequestBody InfomationRequest infomationRequest){
		return infoService.addFriend(infomationRequest);
	}
	
	/**
	 * 好友验证
	 * @return
	 */
	public Message validFriend(@RequestBody FriendListPO friendList){
		return infoService.validFriend(friendList);
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	public Message delFriend(@RequestBody FriendListPO friendList){
		return infoService.delFriend(friendList);
	}

}
