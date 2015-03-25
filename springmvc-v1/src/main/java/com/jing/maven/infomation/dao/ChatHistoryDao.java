package com.jing.maven.infomation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.infomation.entity.ChatHistoryPO;
import com.jing.maven.infomation.entity.FriendStatusPO;

public interface ChatHistoryDao  extends PagingAndSortingRepository<ChatHistoryPO, String>, JpaSpecificationExecutor<ChatHistoryPO>{
	
	@Query(" from ChatHistoryPO t where t.chatId=? ")
	public List<ChatHistoryPO> findByChatId(String chatId);
	
}
