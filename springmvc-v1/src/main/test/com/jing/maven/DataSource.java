package com.jing.maven;

import com.jing.maven.account.entity.AccountPO;

public class DataSource {
	
	public  AccountPO createAccountPO(){
		AccountPO account = new AccountPO();
		account.setAccount("");
		account.setPassword("");
		return account;
	}

}
