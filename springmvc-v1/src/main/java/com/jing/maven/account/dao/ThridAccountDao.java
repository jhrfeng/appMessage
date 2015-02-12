package com.jing.maven.account.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.account.entity.ThridAccountPO;

public interface ThridAccountDao extends PagingAndSortingRepository<ThridAccountPO, String>, JpaSpecificationExecutor<ThridAccountPO>{

	@Query(" select count(*) from ThridAccountPO t where t.openId = ? ")
	public Long getQQ(String openid);
	
	@Query("from ThridAccountPO t where t.openId=?")
	public ThridAccountPO findByQQ(String openid);
	
	@Query(" select count(*) from ThridAccountPO t where t.appId = ? ")
	public Long getWeiXin(String appid);
	
	@Query("from ThridAccountPO t where t.appId=?")
	public ThridAccountPO findByWeiXin(String appid);
}
