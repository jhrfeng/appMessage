package com.jing.maven.infomation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.infomation.entity.FriendListPO;

public interface FriendListDao extends PagingAndSortingRepository<FriendListPO, String>, JpaSpecificationExecutor<FriendListPO>{
	
	@Query(" from FriendListPO t where t.myId=? and t.friendId=? ")
	public FriendListPO findByMidAndFid(String mid, String fid);
	
	@Query("from FriendListPO t where t.myId=? and t.status='1' ")
	public List<FriendListPO> findByMyid(String mid);
	
	
	/*@Query("select tid, myId as friendId, myRemark as friendRemark, status from FriendListPO t where t.friendId=? and t.status='1' ")
	public List<FriendListPO> findByFriendid(String fid);*/
	

}
