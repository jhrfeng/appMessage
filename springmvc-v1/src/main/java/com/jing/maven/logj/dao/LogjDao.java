package com.jing.maven.logj.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.logj.entity.LogjPO;

public interface LogjDao extends PagingAndSortingRepository<LogjPO, String>, JpaSpecificationExecutor<LogjPO>{

}
