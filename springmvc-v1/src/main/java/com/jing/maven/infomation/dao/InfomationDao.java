package com.jing.maven.infomation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.jing.maven.infomation.entity.InfomationPO;


public interface InfomationDao extends PagingAndSortingRepository<InfomationPO, String>, JpaSpecificationExecutor<InfomationPO>{
	
//	@Query("select new InfomationPO(tid, honeyName, sex, province, area) from InfomationPO t left join AccountPO a on t.tid = a.infoid ") 后面在添加 and t.tid != myid;
	//@Query("select new InfomationPO(tid, honeyName, sex, province, area) from InfomationPO t where ( t.tid in (select a.infoid from AccountPO a where a.account like %:matchKey% ) or t.honeyName like %:matchKey% )")
//	@Query(" from InfomationPO t where t.tid in (select a.infoid from AccountPO a where a.account like %:matchKey% ) or t.honeyName like %:matchKey% ")
	//public List<InfomationPO> searchFriend(@Param("matchKey") String matchKey, @Param("myid") String myid);
	
	@Query("select new InfomationPO(tid, nickname, sex, province, area) from InfomationPO t where (t.tid in (select a.infoid from ThridAccountPO a where a.autoAccount = :matchKey) or t.nickname like %:matchKey%) and t.tid != :myid ")
	public List<InfomationPO> searchFriend(@Param("matchKey") String matchKey, @Param("myid") String myid);

}
