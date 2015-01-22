package com.jing.maven.infomation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jing.maven.infomation.dao.FriendListDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

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
		//FriendListPO upFreiend = friendListDao.findByMidAndFid(currentid, friend.getFriendId());
		FriendListPO upFriend = friendListDao.findOne(friend.getTid());
		if(null != friend.getMyId()){
			upFriend.setMyRemark(friend.getMyRemark());
			friendListDao.save(upFriend);
			message.setOptStatus(true);
			message.setMessage("修改成功");
		}else if(null != friend.getFriendId()){
			upFriend.setFriendRemark(friend.getFriendRemark());
			friendListDao.save(upFriend);
			message.setOptStatus(true);
			message.setMessage("修改成功");
		}else{
			message.setOptStatus(false);
			message.setMessage("修改失败");
		}		
		return message;
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	public List<FriendVo> loadFriendList(InfomationRequest infoRequest){
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
	public InfomationPO searchFriend(InfomationRequest infoRequest){
		return null;
	}
	
	/**
	 * 好友验证
	 * @return
	 */
	public Message validFriend(InfomationPO infomation){
		return null;
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	public Message delFriend(InfomationRequest infoRequest){
		return null;
	}
}
