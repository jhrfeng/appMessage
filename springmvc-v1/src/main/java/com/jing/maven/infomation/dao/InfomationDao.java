package com.jing.maven.infomation.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.infomation.entity.InfomationPO;

public interface InfomationDao extends PagingAndSortingRepository<InfomationPO, String>, JpaSpecificationExecutor<InfomationPO>{

}
