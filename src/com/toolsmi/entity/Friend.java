package com.toolsmi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Friend entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "friend", catalog = "contributionmanager")
public class Friend implements java.io.Serializable {

	// Fields

	private Integer id;
	private String realname;
	private String sex;
	private Date birthday;
	private Integer age;
	private String phone;
	private String address;
	private String email;
	private Integer userid;

	// Constructors

	/** default constructor */
	public Friend() {
	}

	/** minimal constructor */
	public Friend(String phone, Integer userid) {
		this.phone = phone;
		this.userid = userid;
	}

	/** full constructor */
	public Friend(String realname, String sex, Date birthday, Integer age,
			String phone, String address, String email, Integer userid) {
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.userid = userid;
	}

	public Friend(Integer id, String realname, String sex, Date birthday,
			String phone, String address, String email) {
		this.id = id;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "realname", length = 20)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Column(name = "sex", length = 1)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "phone", nullable = false, length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "address", length = 50)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "email", length = 20)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "userid", nullable = false)
	public Integer getUserid() {
		return this.userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

}