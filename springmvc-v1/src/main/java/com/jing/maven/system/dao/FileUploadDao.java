package com.jing.maven.system.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.jing.maven.system.entity.FeedbackPO;
import com.jing.maven.system.entity.FileUploadPO;

public interface FileUploadDao extends PagingAndSortingRepository<FileUploadPO, String>, JpaSpecificationExecutor<FileUploadPO>{

}

