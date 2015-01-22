package com.jing.maven.account.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.account.entity.AccountRolePO;


public interface AccountRoleDao  extends PagingAndSortingRepository<AccountRolePO, String>, JpaSpecificationExecutor<AccountRolePO>{

}
