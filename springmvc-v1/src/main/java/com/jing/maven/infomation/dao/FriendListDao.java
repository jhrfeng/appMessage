package com.jing.maven.infomation.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.infomation.entity.FriendListPO;

public interface FriendListDao extends PagingAndSortingRepository<FriendListPO, String>, JpaSpecificationExecutor<FriendListPO>{
	
	@Query(" from FriendListPO t where t.myId=? and t.friendId=? ")
	public FriendListPO findByMidAndFid(String mid, String fid);
	
	

}
