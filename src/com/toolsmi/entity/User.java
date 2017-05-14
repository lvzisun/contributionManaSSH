package com.toolsmi.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "contributionmanager")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private String realname;
	private String sex;
	private Date birthday;
	private Integer age;
	private String phone;
	private String address;
	private String email;
	private Integer status;
	private Integer roleid;
	private Double credit;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String password, String phone, Integer status,
			Integer roleid) {
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.status = status;
		this.roleid = roleid;
	}

	/** full constructor */
	public User(String username, String password, String realname, String sex,
			Date birthday, Integer age, String phone, String address,
			String email, Integer status, Integer roleid, Double credit) {
		this.username = username;
		this.password = password;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.status = status;
		this.roleid = roleid;
		this.credit = credit;
	}

	public User(Integer id, String username, String realname, String sex,
			Date birthday, Integer age, String phone, String address,
			String email, Integer status, Integer roleid, Double credit) {
		this.id = id;
		this.username = username;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.email = email;
		this.status = status;
		this.roleid = roleid;
		this.credit = credit;
	}
	
	

	public User(Integer id, String realname, String sex, Date birthday,
			String phone, String address, String email) {
		this.id = id;
		this.realname = realname;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.email = email;
	}
	
	public User(String realname){
		this.realname=realname;
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

	@Column(name = "username", nullable = false, length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "roleid", nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "credit", precision = 4, scale = 3)
	public Double getCredit() {
		return this.credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

}