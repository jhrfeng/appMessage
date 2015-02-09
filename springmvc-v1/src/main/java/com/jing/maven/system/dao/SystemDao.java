package com.jing.maven.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.system.entity.FeedbackPO;

public interface SystemDao extends PagingAndSortingRepository<FeedbackPO, String>, JpaSpecificationExecutor<FeedbackPO>{

}
