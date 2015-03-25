package com.jing.maven.account.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.account.entity.OtherAccountPO;
import com.jing.maven.account.entity.ThridAccountPO;

public interface OtherAccountDao extends PagingAndSortingRepository<OtherAccountPO, String>, JpaSpecificationExecutor<OtherAccountPO>{

	@Query(" select count(*) from OtherAccountPO t where t.appId = ?")
	public Long findcountByAppId(String appId);
	
	@Query("select count(*) from OtherAccountPO t where t.appId=? and t.type=?")
	public Long findcountByAppIdAndType(String appId, String type);
	
	@Query("from OtherAccountPO t where t.appId=?")
	public OtherAccountPO findByAppId(String appId); 
	
	@Query("from OtherAccountPO t where t.appId=? and t.type=?")
	public OtherAccountPO findByAppIdAndType(String appId, String type);
	
}
