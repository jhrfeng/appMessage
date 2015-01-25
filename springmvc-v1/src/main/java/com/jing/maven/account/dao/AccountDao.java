package com.jing.maven.account.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.account.entity.AccountPO;

public interface AccountDao extends PagingAndSortingRepository<AccountPO, String>, JpaSpecificationExecutor<AccountPO>{
	
	@Query(" from AccountPO t where t.account = ?")
	public AccountPO findByAccount(String account);
	
	@Query(" select count(*) from AccountPO t where t.account = ? ")
	public Long countByAccount(String account);

}
