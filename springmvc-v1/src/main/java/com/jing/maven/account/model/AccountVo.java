package com.jing.maven.account.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.jing.maven.account.entity.AccountPO;
import com.jing.maven.infomation.entity.FriendStatusPO;
import com.jing.maven.manager.entity.Message;

@JsonInclude(Include.NON_NULL)  
public class AccountVo extends Message{

	private FriendStatusPO friendStatus;
	
	private AccountPO account;

	public FriendStatusPO getFriendStatus() {
		return friendStatus;
	}

	public void setFriendStatus(FriendStatusPO friendStatus) {
		this.friendStatus = friendStatus;
	}

	public AccountPO getAccount() {
		return account;
	}

	public void setAccount(AccountPO account) {
		this.account = account;
	}
	
	
	
	
}
