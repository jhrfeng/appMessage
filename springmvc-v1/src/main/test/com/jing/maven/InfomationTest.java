package com.jing.maven;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jing.maven.account.service.AccountService;
import com.jing.maven.infomation.entity.FriendListPO;
import com.jing.maven.infomation.entity.InfomationPO;
import com.jing.maven.infomation.model.InfomationRequest;
import com.jing.maven.infomation.service.InfomationService;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"classpath:conf/applicationContext.xml" })
public class InfomationTest {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private InfomationService infoService;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * 个人好友信息查看接口
	 * @param infoRequest
	 * @return
	 */
	//@Test
	public void showInfo(){
		InfomationRequest infoRequest = new InfomationRequest();
		infoRequest.setRequestId("402884e54b1f3e4d014b1f3fbef80001");
		infoService.showInfo(infoRequest);
	}
	
	/**
	 * 个人好友信息修改接口
	 * @param infomation
	 * @return
	 */
	//@Test
	public void updateInfo(){
		InfomationPO infomation = new InfomationPO();
		infomation.setTid("402884e54b1f3e4d014b1f3fbef80001");
		infomation.setAddr("abc");
		infomation.setAge("22");
		infomation.setArea("11");
		infomation.setBirthday("2012/12/12");
		infomation.setCity("11");
		infomation.setCreateDate("2012/12/12");
		infomation.setEmail("123456@qq.com");
		infomation.setGrade("01");
		infomation.setHoneyName("hellowkitty");
		infomation.setMobile("12345678941");
		infomation.setProvince("12");
		infomation.setQq("1059731125");
		infomation.setRemark("12333345");
		infomation.setSchool("上海海大附属中学");
		infomation.setSex("1");
		infomation.setUpdateDate("2012/12/12");
		infomation.setUpdateId("currentid");
		infoService.updateInfo(infomation);
	}
	
	/**
	 * 好友备注修改
	 * @param friend
	 * @return
	 */
	//@Test
	public void updateRemark(){
		FriendListPO friend = new FriendListPO();
		friend.setTid("402884e54b211439014b21151ab80001");
		friend.setFriendId("402884e54b1f3e4d014b1f3fbef80001");
		friend.setFriendRemark("王小鹰1");
		 infoService.updateRemark(friend);
	}
	
	/**
	 * 加载好友列表
	 * @param infoRequest
	 * @return
	 */
	//@Test
	public void loadFriendList(){
		InfomationRequest infoRequest = new InfomationRequest();
		infoRequest.setRequestId("402884e54b1f4369014b1f437dda0000");
		 infoService.loadFriendList(infoRequest);
	}
	
	/**
	 * 好友推荐
	 * @return
	 */
	public void introduceFriend(){
		 infoService.introduceFriend();
	}
	
	/**
	 * 好友查找
	 * @param infoRequest
	 * @return
	 */
	//@Test
	public void searchFriend(){
		InfomationRequest infoRequest = new InfomationRequest();
		infoRequest.setRequestName("hell");
		 infoService.searchFriend(infoRequest);
	}
	
	/**
	 * 好友新增
	 * @param infomationRequest
	 * @return
	 */
	@Test
	public void addFriend(){
		InfomationRequest infoRequest = new InfomationRequest();
		infoRequest.setRequestId("402884e54b1f3e4d014b1f3fbef80001");
		 infoService.addFriend(infoRequest);
	}
	
	/**
	 * 好友验证
	 * @return
	 */
	public void validFriend(){
		FriendListPO friendList = new FriendListPO();
		 infoService.validFriend(friendList);
	}
	
	/**
	 * 好友删除
	 * @param infoRequest
	 * @return
	 */
	//@Test
	public void delFriend(){
		FriendListPO friendList = new FriendListPO();
		friendList.setTid("402884e54b219abb014b219b22270001");
		friendList.setFriendId("402884e54b1f3e4d014b1f3fbef80001");
		infoService.delFriend(friendList);
	}
	
	
}
