package com.jing.maven.manager.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * 统一定义id的entity基类.
 * 
 * 基类统一定义id的属性名称、数据类型、列名映射及生成策略.
 * 子类可重载getId()函数重定义id的列名映射和生成策略.
 * 
 */
//JPA 基类的标识
@MappedSuperclass
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id")
public abstract class IdEntity  implements Serializable{
	
	protected Long tid;
	protected Integer optlock;
	
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@GeneratedValue(strategy = GenerationType.SEQUENCE)
	//@GeneratedValue(generator = "system-uuid")
	//@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Id
	@SequenceGenerator(name = "generator", sequenceName = "CRM_SEQUENCE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	public Long getTid() {
		return tid;
	}
	
	@Version
	@Column(name="OPTLOCK")
	public Integer getOptlock() {
		return optlock;
	}

	public void setOptlock(Integer optlock) {
		this.optlock = optlock;
	}

	public void setTid(Long tid) {
		this.tid = tid;
	}
	
}
