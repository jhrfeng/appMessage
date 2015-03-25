package com.jing.maven.infomation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jing.maven.common.system.BaseController;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.infomation.service.InfomationService;
import com.jing.maven.manager.entity.Message;

@Controller
@RequestMapping("information")
public class InfomationController extends BaseController{
	
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
	@RequestMapping("/modifyInfo")
	@ResponseBody
	public Message updateInfo(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.updateInfo(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	@RequestMapping("/updateRemark")
	@ResponseBody
	public Message updateRemark(@RequestBody FriendListPO friend){
		if(authLogin()){
			return infoService.updateRemark(friend);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/loadFriendList")
	@ResponseBody
	public FriendVo loadFriendList(@RequestBody InfomationRequest infoRequest){
		if(authLogin()){
			return infoService.loadFriendList(infoRequest);
		}else{
			FriendVo friendVo = new FriendVo();
			friendVo.setOptCode("500");
			friendVo.setOptStatus(false);
			friendVo.setMessage("没有权限访问");
			return friendVo;
		}
		
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
		if(authLogin()){
			return infoService.searchFriend(infoRequest);
		}else{
			FriendVo friendVo = new FriendVo();
			friendVo.setOptCode("500");
			friendVo.setOptStatus(false);
			friendVo.setMessage("没有权限访问");
			return friendVo;
		}
	}
	
	/**
	 * 好友新增
	 * @param infomationRequest
	 * @return
	 */
	@RequestMapping("/addFriend")
	@ResponseBody
	public Message addFriend(@RequestBody FriendListPO infomationRequest){
		if(authLogin()){
			return infoService.addFriend(infomationRequest);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 好友验证
	 * @return
	 */
	@RequestMapping("/validFriend")
	@ResponseBody
	public Message validFriend(@RequestBody FriendListPO friendList){
		if(authLogin()){
			return infoService.validFriend(friendList);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	@RequestMapping("/delFriend")
	@ResponseBody
	public Message delFriend(@RequestBody FriendListPO friendList){
		if(authLogin()){
			return infoService.delFriend(friendList);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}

	/**
	 * 修改昵称
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/modify_honeyname")
	@ResponseBody
	public Message update_HoneyName(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_HoneyName(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 修改备注
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/modify_remark")
	@ResponseBody
	public Message update_Remark(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_Remark(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	@RequestMapping("modify_signature")
	public Message update_signature(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_signature(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
	
	}
	
	/**
	 * 修改生日
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/modify_birthday")
	@ResponseBody
	public Message update_birthday(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_birthday(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 修改地区
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/modify_area")
	@ResponseBody
	public Message update_area(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_province(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 修改学校
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/modify_school")
	@ResponseBody
	public Message update_school(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_school(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
		
	}
	
	/**
	 * 修改班级
	 * @param infomation
	 * @return
	 */
	@RequestMapping("/modify_class")
	@ResponseBody
	public Message update_class(@RequestBody InfomationPO infomation){
		if(authLogin()){
			return infoService.update_class(infomation);
		}else{
			return new Message("500",false, "没有权限访问");
		}
	
	}
	
}
