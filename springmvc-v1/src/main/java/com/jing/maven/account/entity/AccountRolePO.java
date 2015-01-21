package com.jing.maven.account.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jing.maven.manager.entity.IdEntity;

/**
 * 账号角色表
 * 2015-1-20 22:40:16
 * @author jinghr
 *
 */
@Entity
@Table(name = "app_account_role")
public class AccountRolePO extends IdEntity {
	
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
	/**
	 * 角色CODE
	 */
	private String roleCode;
	
	/**
	 * 账号信息表外键
	 */
	private String accountid;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 修改时间
	 */
	private String updateDate;

	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	

}
