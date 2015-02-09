package com.jing.maven.infomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.infomation.service.InfomationService;
import com.jing.maven.manager.entity.Message;

@Controller
@RequestMapping("infomation")
public class InfomationController {
	
	@Autowired
	private InfomationService infoService;
	
	/**
	 * 个人好友信息查看接口
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/showInfo")
	@ResponseBody
	public InfomationPO showInfo(@RequestBody InfomationRequest infoRequest){		
		return infoService.showInfo(infoRequest);
	}
	
	/**
	 * 个人好友信息修改接口
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/updateInfo")
	@ResponseBody
	public Message updateInfo(@RequestBody InfomationPO infomation){
		return infoService.updateInfo(infomation);
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	@RequestMapping("/updateRemark")
	@ResponseBody
	public Message updateRemark(@RequestBody FriendListPO friend){
		return infoService.updateRemark(friend);
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/loadFriendList")
	@ResponseBody
	public FriendVo loadFriendList(@RequestBody InfomationRequest infoRequest){
		return infoService.loadFriendList(infoRequest);
	}
	
	/**
	 * 好友推荐
	 * @return
	 */
	@RequestMapping("/introduce")
	@ResponseBody
	public List<InfomationPO> introduceFriend(){
		return infoService.introduceFriend();
	}
	
	/**
	 * 好友查找
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/searchFriend")
	@ResponseBody
	public FriendVo searchFriend(@RequestBody InfomationRequest infoRequest){
		return infoService.searchFriend(infoRequest);
	}
	
	/**
	 * 好友新增
	 * @param infomationRequest
	 * @return
	 */
	@RequestMapping("/addFriend")
	@ResponseBody
	public Message addFriend(@RequestBody FriendListPO infomationRequest){
		return infoService.addFriend(infomationRequest);
	}
	
	/**
	 * 好友验证
	 * @return
	 */
	@RequestMapping("/validFriend")
	@ResponseBody
	public Message validFriend(@RequestBody FriendListPO friendList){
		return infoService.validFriend(friendList);
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/delFriend")
	@ResponseBody
	public Message delFriend(@RequestBody FriendListPO friendList){
		return infoService.delFriend(friendList);
	}

	/**
	 * 修改昵称
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/up_honeyname")
	@ResponseBody
	public Message update_HoneyName(@RequestBody InfomationPO infomation){
		return infoService.update_HoneyName(infomation);
	}
	
	/**
	 * 修改签名
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/up_remark")
	@ResponseBody
	public Message update_Remark(@RequestBody InfomationPO infomation){
		return infoService.update_Remark(infomation);
	}
	
	/**
	 * 修改生日
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/up_birthday")
	@ResponseBody
	public Message update_birthday(@RequestBody InfomationPO infomation){
		return infoService.update_birthday(infomation);
	}
	
	/**
	 * 修改地区
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/up_area")
	@ResponseBody
	public Message update_area(@RequestBody InfomationPO infomation){
		return infoService.update_province(infomation);
	}
	
	/**
	 * 修改学校
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/up_school")
	@ResponseBody
	public Message update_school(@RequestBody InfomationPO infomation){
		return infoService.update_school(infomation);
	}
	
	/**
	 * 修改班级
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/up_class")
	@ResponseBody
	public Message update_class(@RequestBody InfomationPO infomation){
		return infoService.update_class(infomation);
	}
	
}
