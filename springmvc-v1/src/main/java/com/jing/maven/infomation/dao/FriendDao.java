package com.jing.maven.infomation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.FriendPO;

public interface FriendDao extends PagingAndSortingRepository<FriendPO, String>, JpaSpecificationExecutor<FriendPO>{
		
	@Query("from FriendPO t where t.myId=? and t.status='1' ")
	public List<FriendPO> findByMyid(String mid);

}
