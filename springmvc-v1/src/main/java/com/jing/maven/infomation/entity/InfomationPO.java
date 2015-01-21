package com.jing.maven.infomation.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.jing.maven.manager.entity.IdEntity;


/**
 * 个人信息表
 * 2015-1-20 22:50:25
 * @author jinghr
 *
 */
@Entity
@Table(name = "app_infomation")
public class InfomationPO  extends IdEntity {
	private static final long serialVersionUID = 2433461464054606867L;
	
	/**
	 * 昵称
	 */
	private String honeyName;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 出生日期
	 */
	private String birthday;
	
	/**
	 * 年龄
	 */
	private String age;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 城市
	 */
	private String city;
	
	/**
	 * 地区
	 */
	private String area;
	
	/**
	 * 地址
	 */
	private String addr;
	
	/**
	 * 学校
	 */
	private String school;
	
	/**
	 * 年级
	 */
	private String grade;
	
	/**
	 * 记录
	 */
	private String remark;
	
	/**
	 * 手机
	 */
	private String mobile;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * QQ
	 */
	private String qq;
	
	/**
	 * 创建时间
	 */
	private String createDate;
	
	/**
	 * 更新时间
	 */
	private String updateDate;
	
	/**
	 * 操作人ID
	 */
	private String updateId;

	
	public String getHoneyName() {
		return honeyName;
	}

	public void setHoneyName(String honeyName) {
		this.honeyName = honeyName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
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

	public String getUpdateId() {
		return updateId;
	}

	public void setUpdateId(String updateId) {
		this.updateId = updateId;
	}
	
	
	

}
