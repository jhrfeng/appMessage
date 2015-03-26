package com.jing.maven.infomation.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.jing.maven.common.system.BaseService;
import com.jing.maven.infomation.dao.FriendListDao;
import com.jing.maven.infomation.dao.FriendStatusDao;
import com.jing.maven.infomation.dao.InfomationDao;
import com.jing.maven.infomation.entity.ChatHistoryPO;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.ChatRequest;
import com.jing.maven.infomation.model.ChatVo;
import com.jing.maven.infomation.model.FriendListVo;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.manager.entity.Message;

@Service
public class ChatHistoryService extends BaseService{
	
	@Autowired
	private InfomationDao infomationDao;
	
	@Autowired
	private FriendListDao friendListDao;
	
	@Autowired
	private FriendStatusDao friendStatusDao;

	public ChatVo saveChatHistory(ChatRequest chatContent){
		ChatVo chat = new ChatVo();
		String chatId;
		try{
			if(chatContent.getSendId().compareTo(chatContent.getReceiveId()) < 0){
				chatId = chatContent.getSendId()+chatContent.getReceiveId();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
