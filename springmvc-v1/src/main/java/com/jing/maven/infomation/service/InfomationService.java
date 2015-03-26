package com.jing.maven.infomation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.common.system.BaseService;
import com.jing.maven.infomation.dao.FriendDao;
import com.jing.maven.infomation.dao.FriendListDao;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.FriendPO;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.FriendListVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.infomation.model.InformationVo;
import com.jing.maven.infomation.model.SearchFriendVo;
import com.jing.maven.infomation.request.InformationReq;
import com.jing.maven.infomation.response.FriendRes;
import com.jing.maven.manager.entity.Message;

@Service
public class InfomationService extends BaseService{
	
	@Autowired
	private InfomationDao infomationDao;
	
	@Autowired
	private FriendListDao friendListDao;
	
	@Autowired
	private FriendStatusDao friendStatusDao;
	
	@Autowired FriendDao friendDao;

	/**
	 * 个人信息查看接口
	 * @param infoRequest
	 * @return
	 */
	public InformationVo showInfo(){
		InformationVo infomation = new InformationVo();
		try{
			String id = inputId(); //当前登录用户信息id
			InfomationPO  info = infomationDao.findOne(id);	
			  if(null==info){
			    	infomation.setOptCode("410"); //数据库未查询到数据
			    	infomation.setOptStatus(false);
			    	infomation.setMessage("未查找到数据");
			    	return infomation;
			    }else{
			    	infomation.setOptCode("200");
			    	infomation.setOptStatus(true);
			    	infomation.setMessage("查询成功");
			    	infomation.setInformation(infomationPOConvertRes(info));
			    	return infomation;
			    }
			}catch(Exception e){
				/** 日志记录 **/
				infomation.setOptCode("510"); //代码异常
		    	infomation.setOptStatus(false);
		    	infomation.setMessage("处理发生异常");
				return infomation;
		}
	}
	
	/**
	 * 好友信息查看接口
	 * @param infoRequest
	 * @return
	 */
	public InformationVo findOtherInfo(InformationReq infoRequest){
		InformationVo infomation = new InformationVo();
		try{
			String id = infoRequest.getTid();
		    InfomationPO  info = infomationDao.findOne(id);	
		    if(null==info){
		    	infomation.setOptCode("410"); //数据库未查询到数据
		    	infomation.setOptStatus(false);
		    	infomation.setMessage("未查找到数据");
		    	return infomation;
		    }else{
		    	infomation.setOptCode("200");
		    	infomation.setOptStatus(true);
		    	infomation.setMessage("查询成功");
		    	infomation.setInformation(infomationPOConvertRes(info));
		    	return infomation;
		    }
		}catch(Exception e){
			/** 日志记录 **/
			infomation.setOptCode("510"); //代码异常
	    	infomation.setOptStatus(false);
	    	infomation.setMessage("处理发生异常");
			return infomation;
		}
	}
	
	/**
	 * 个人好友信息修改接口
	 * @param infomation
	 * @return
	 */
	public Message updateInfo(InformationReq infomation){
		Message message = new Message();
		try{
			if(null != infomation.getTid()){			
				InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
				upInfo.setAddr(infomation.getAddr());
				//upInfo.setAge(infomation.getAge());
				upInfo.setArea(infomation.getArea());
				upInfo.setBirthday(infomation.getBirthday());
				upInfo.setCity(infomation.getCity());
				//upInfo.setEmail(infomation.getEmail());
				upInfo.setGrade(infomation.getGrade());
				upInfo.setNickname(infomation.getNickname());
				//upInfo.setMobile(infomation.getMobile());
				upInfo.setProvince(infomation.getProvince());
			//	upInfo.setQq(infomation.getQq());
			//	upInfo.setRemark(infomation.getRemark());
				upInfo.setSchool(infomation.getSchool());
				upInfo.setSex(infomation.getSex());
				upInfo.setUpdateDate(formatUpdateDate(new Date()));
				upInfo.setUpdateId(inputId()); //操作人
				infomationDao.save(upInfo);
				/***********日志记录***************/
				message.setOptCode("200");
				message.setOptStatus(true);
				message.setMessage("信息修改成功");		
			}else{
				message.setOptCode("520"); //请求数据错误
				message.setOptStatus(false);
				message.setMessage("个人信息修改失败，无法获取到主键");	
			}
			return message;
		}catch(Exception e){
			message.setOptCode("510"); //程序处理错误
			message.setOptStatus(false);
			message.setMessage("发生异常");
			return message;
		}
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	public Message modifyFriendRemark(InformationReq friend){
		Message message = new Message();
		try{
			FriendListPO upFriend = friendListDao.findOne(friend.getTid());
		    if(null != friend.getTid() && friend.getTid().equals(upFriend.getFriendId())){
				upFriend.setFriendRemark(friend.getFriendMark());
				friendListDao.save(upFriend);
				message.setOptCode("200");
				message.setOptStatus(true);
				message.setMessage("修改成功");
			}else{
				message.setOptCode("520"); //请求数据有误
				message.setOptStatus(false);
				message.setMessage("请求数据错误");
			}
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptCode("510");//程序处理错误
			message.setOptStatus(false);
			message.setMessage("发生异常");
			return message;
		}
		
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	public FriendListVo loadFriendList(){
		
		FriendListVo friendVo = new FriendListVo();
		try{			
			//加载我的好友列表
			List<FriendPO> myfriendList = friendDao.findByMyid(inputId());
			friendVo.setFriendList(friendPOConverRes(myfriendList));
			friendVo.setOptCode("200");
			friendVo.setOptStatus(true);
			friendVo.setMessage("加载好友列表成功");
			return friendVo;
		}catch(Exception e){
			e.printStackTrace();
			friendVo.setOptCode("510"); //程序处理错误
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
	public SearchFriendVo searchFriend(InfomationRequest infoRequest){
		SearchFriendVo friendVo = new SearchFriendVo();
		try{
			/****************/
				//这里应该把自己给排除掉
			String myid = inputId();
			/****************/
			List<InfomationPO> friendList = infomationDao.searchFriend(infoRequest.getRequestName(), myid);
			friendVo.setInfomationList(friendList);
			friendVo.setOptCode("200");
			friendVo.setOptStatus(true);
			friendVo.setMessage("共"+friendList.size()+"位相关好友");
			return friendVo;
		}catch(Exception e){
			e.printStackTrace();
			friendVo.setOptCode("400");
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
	public Message addFriend(FriendListPO infomationRequest){
		
		Message message = new Message();		
		try{	
			message.setOptCode("200");
			message.setOptStatus(true);
			message.setMessage("新增成功");	
			
			/** 获取当前用户信息ID  **/
		//	String currentid = "402884e54b1f4369014b1f437dda0000";
			
			// 防止自己加自己为好友
			if(infomationRequest.getMyId().equals(infomationRequest.getFriendId())){
				message.setOptCode("400");
				message.setOptStatus(false);
				message.setMessage("新增失败,不能添加自己为好友");
				return message;
			}
			/***********************/
			//检查之前是否已建立好友关系, 如果建立更改状态为 验证，目前为直接加为好友
			FriendListPO findFriend = friendListDao.findByMidAndFid(infomationRequest.getMyId(), infomationRequest.getFriendId());
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
			InfomationPO friendInfo = infomationDao.findOne(infomationRequest.getFriendId());
			FriendStatusPO friendStatus = friendStatusDao.findByMyinfoId(infomationRequest.getFriendId());
			//查找我的信息
			InfomationPO myInfo = infomationDao.findOne(infomationRequest.getMyId());
			FriendStatusPO myStatus = friendStatusDao.findByMyinfoId(infomationRequest.getMyId());

			FriendListPO friendList = new FriendListPO();
			friendList.setMyId(infomationRequest.getMyId());
			friendList.setFriendId(infomationRequest.getFriendId());
			//friendList.setStatus("2"); //验证
			friendList.setStatus("1"); //默认为好友
			friendList.setNickname(friendInfo.getNickname());
			//friendList.setMyRemark(friendInfo.getHoneyName()); //你的昵称
			friendList.setFriendSip(friendStatus.getSipAccount());
			friendListDao.save(friendList);  //主动添加好友
			
			friendList = new FriendListPO();
			friendList.setMyId(infomationRequest.getFriendId());
			friendList.setFriendId(infomationRequest.getMyId());
			friendList.setStatus("1");
			friendList.setNickname(myInfo.getNickname());
		//	friendList.setMyRemark(myInfo.getHoneyName()); //我的昵称
			friendList.setFriendSip(myStatus.getSipAccount());
			friendListDao.save(friendList);  //被动添加好友
						
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptCode("400");
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
			String friendid = friendList.getFriendId();
			friendList = friendListDao.findOne(friendList.getTid());
			if(friendid.equals(friendList.getFriendId())){				
				friendList.setStatus("4");  //删除
				friendListDao.save(friendList);
				message.setOptStatus(true);
				message.setMessage("删除成功");
				return  message;
			}else{
				message.setOptStatus(false);
				message.setMessage("没有找到匹配好友，无法删除");
				return  message;
			}
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("删除失败");
			return message;
		}
	}
	
	/**
	 * 修改昵称
	 * @param infomation
	 * @return
	 */
	public Message update_HoneyName(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setNickname(infomation.getNickname());
			//upInfo.setHoneyName(infomation.getHoneyName());
			upInfo.setUpdateDate("2012/12/12");
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptCode("200");
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptCode("400");
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
	
	/**
	 * 修改备注
	 * @param infomation
	 * @return
	 */
	public Message update_Remark(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setRemark(infomation.getRemark());
			upInfo.setUpdateDate(formatUpdateDate(new Date()));
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
	
	public Message update_signature(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setSignature(infomation.getSignature());
			upInfo.setUpdateDate(formatUpdateDate(new Date()));
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
	
	
	/**
	 * 修改生日
	 * @param infomation
	 * @return
	 */
	public Message update_birthday(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
	//		upInfo.setHoneyName(infomation.getHoneyName());
			upInfo.setNickname(infomation.getNickname());
			upInfo.setUpdateDate(formatUpdateDate(new Date()));
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
	
	/**
	 * 修改地区
	 * @param infomation
	 * @return
	 */
	public Message update_province(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setProvince(infomation.getProvince());
			upInfo.setArea(infomation.getArea());
			upInfo.setUpdateDate(formatUpdateDate(new Date()));
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
	
	/**
	 * 修改学校
	 * @param infomation
	 * @return
	 */
	public Message update_school(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setSchool(infomation.getSchool());
			upInfo.setUpdateDate(formatUpdateDate(new Date()));
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptCode("200");
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptCode("400");
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
	
	/**
	 * 修改班级
	 * @param infomation
	 * @return
	 */
	public Message update_class(@RequestBody InfomationPO infomation){
		Message message = new Message();
		try{
			InfomationPO upInfo = infomationDao.findOne(infomation.getTid());
			upInfo.setGrade(infomation.getGrade());
			upInfo.setClassroom(infomation.getClassroom());
			upInfo.setUpdateDate(formatUpdateDate(new Date()));
			upInfo.setUpdateId(inputId());
			infomationDao.save(upInfo);
			message.setOptCode("200");
			message.setOptStatus(true);
			message.setMessage("修改成功");
			return message;
		}catch(Exception e){
			e.printStackTrace();
			message.setOptCode("400");
			message.setOptStatus(false);
			message.setMessage("修改失败");
			return message;
		}
	}
}
