package com.jing.maven.infomation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.infomation.dao.FriendListDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

@Service
public class InfomationService {
	
	@Autowired
	private InfomationDao infomationDao;
	
	@Autowired
	private FriendListDao friendListDao;

	/**
	 * 个人好友信息查看接口
	 * @param infoRequest
	 * @return
	 */
	public InfomationPO showInfo(InfomationRequest infoRequest){
		InfomationPO infomation = new InfomationPO();
		try{
			String id = infoRequest.getRequestId();
			if(null==id)	id = ""; //当前登录用户信息id
		    infomation = infomationDao.findOne(infoRequest.getRequestId());		
		    return infomation;
		}catch(Exception e){
			/** 日志记录 **/
			
			
			return infomation;
		}
	}
	
	/**
	 * 个人好友信息修改接口
	 * @param infomation
	 * @return
	 */
	public Message updateInfo(InfomationPO infomation){
		Message message = new Message();
		if(null != infomation.getTid()){			
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setAddr(infomation.getAddr());
			upInfo.setAge(infomation.getAge());
			upInfo.setArea(infomation.getArea());
			upInfo.setBirthday(infomation.getBirthday());
			upInfo.setCity(infomation.getCity());
			upInfo.setEmail(infomation.getEmail());
			upInfo.setGrade(infomation.getGrade());
			upInfo.setHoneyName(infomation.getHoneyName());
			upInfo.setMobile(infomation.getMobile());
			upInfo.setProvince(infomation.getProvince());
			upInfo.setQq(infomation.getQq());
			upInfo.setRemark(infomation.getRemark());
			upInfo.setSchool(infomation.getSchool());
			upInfo.setSex(infomation.getSex());
			upInfo.setUpdateDate("2012/12/12");
			upInfo.setUpdateId(""); //操作人
			infomationDao.save(upInfo);
			message.setOptStatus(true);
			message.setMessage("信息修改成功");		
		}else{
			message.setOptStatus(false);
			message.setMessage("个人信息修改失败，无法获取到主键");
		}
		
		return message;
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	public Message updateRemark(FriendListPO friend){
		Message message = new Message();
		try{
			//FriendListPO upFreiend = friendListDao.findByMidAndFid(currentid, friend.getFriendId());
			FriendListPO upFriend = friendListDao.findOne(friend.getTid());
		    if(null != friend.getFriendId() && friend.getFriendId().equals(upFriend.getFriendId())){
				upFriend.setFriendRemark(friend.getFriendRemark());
				friendListDao.save(upFriend);
				
				message.setOptStatus(true);
				message.setMessage("修改成功");
			}else{
				message.setOptStatus(false);
				message.setMessage("修改失败");
			}
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
		
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	public FriendVo loadFriendList(InfomationRequest infoRequest){
		
		FriendVo friendVo = new FriendVo();
		try{			
			//加载我的好友列表
			List<FriendListPO> myfriendList = friendListDao.findByMyid(infoRequest.getRequestId());
			/**************************/
			   // 加载好友语音账号
			
			/**************************/
			
			
			friendVo.setFriendList(myfriendList);
			friendVo.setOptStatus(true);
			friendVo.setMessage("加载好友列表成功");
			return friendVo;
		}catch(Exception e){
			e.printStackTrace();
			friendVo.setOptStatus(false);
			friendVo.setMessage("好友列表加载失败");
			return friendVo;
		}
		
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
	public FriendVo searchFriend(InfomationRequest infoRequest){
		FriendVo friendVo = new FriendVo();
		try{
			List<InfomationPO> friendList = infomationDao.searchFriend(infoRequest.getRequestName());
			friendVo.setInfomationList(friendList);
			friendVo.setOptStatus(true);
			friendVo.setMessage("共"+friendList.size()+"位相关好友");
			return friendVo;
		}catch(Exception e){
			e.printStackTrace();
			friendVo.setOptStatus(false);
			friendVo.setMessage("查找失败");
			return friendVo;
		}
		
		
	}
	
	/**
	 * 好友新增
	 * @param infomationRequest
	 * @return
	 */
	public Message addFriend(@RequestBody InfomationRequest infomationRequest){
		
		Message message = new Message();		
		try{	
			message.setOptStatus(true);
			message.setMessage("新增成功");	
			
			/** 获取当前用户信息ID  **/
			String currentid = "402884e54b1f4369014b1f437dda0000";
			
			/***********************/
			//检查之前是否已建立好友关系, 如果建立更改状态为 验证，目前为直接加为好友
			FriendListPO findFriend = friendListDao.findByMidAndFid(currentid, infomationRequest.getRequestId());
			if(null != findFriend){
				if("1".equals(findFriend.getStatus())){
					return message;
				}else if("4".equals(findFriend.getStatus())){
					findFriend.setStatus("1"); //删除好友变为 好友
					friendListDao.save(findFriend);
					return message;
				}
			}
			
			/***********************/			
			//查找当前好友信息
			InfomationPO friendInfo = infomationDao.findOne(infomationRequest.getRequestId());
			//查找我的信息
			InfomationPO myInfo = infomationDao.findOne(currentid);

			FriendListPO friendList = new FriendListPO();
			friendList.setMyId(currentid);
			friendList.setFriendId(infomationRequest.getRequestId());
			//friendList.setStatus("2"); //验证
			friendList.setStatus("1"); //默认为好友
			friendList.setMyRemark(friendInfo.getHoneyName()); //你的昵称
			friendListDao.save(friendList);  //主动添加好友
			
			friendList = new FriendListPO();
			friendList.setMyId(infomationRequest.getRequestId());
			friendList.setFriendId(currentid);
			friendList.setStatus("1");
			friendList.setMyRemark(myInfo.getHoneyName()); //我的昵称
			friendListDao.save(friendList);  //被动添加好友
						
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("好友新增失败");
			return message;
		}
	}
	
	
	/**
	 * 好友验证
	 * @return
	 */
	public Message validFriend(FriendListPO friendList){
		Message message = new Message();
		try{
			friendListDao.save(friendList);
			message.setOptStatus(true);
			message.setMessage("验证通过");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("验证失败");
			return message;
		}
		
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	public Message delFriend(FriendListPO friendList){
		Message message = new Message();
		try{			
			friendList = friendListDao.findOne(friendList.getTid());
			friendList.setStatus("4");  //删除
			friendListDao.save(friendList);
			message.setOptStatus(true);
			message.setMessage("删除成功");
			return  message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("删除失败");
			return message;
		}
	}
}
