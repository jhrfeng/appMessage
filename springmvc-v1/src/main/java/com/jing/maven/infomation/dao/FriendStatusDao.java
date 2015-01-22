package com.jing.maven.infomation.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.infomation.entity.FriendStatusPO;

public interface FriendStatusDao  extends PagingAndSortingRepository<FriendStatusPO, String>, JpaSpecificationExecutor<FriendStatusPO>{

}
