package com.jing.maven.account.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.account.entity.ThridAccountPO;

public interface ThridAccountDao extends PagingAndSortingRepository<ThridAccountPO, String>, JpaSpecificationExecutor<ThridAccountPO>{

	@Query(" select count(*) from ThridAccountPO t where t.")
	public Long getQQ();
	
	public Long getWeiXin();
}
