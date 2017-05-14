package com.toolsmi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Rolepowerrelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "rolepowerrelation", catalog = "contributionmanager")
public class Rolepowerrelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer roleid;
	private Integer fpowerid;

	// Constructors

	/** default constructor */
	public Rolepowerrelation() {
	}

	/** full constructor */
	public Rolepowerrelation(Integer roleid, Integer fpowerid) {
		this.roleid = roleid;
		this.fpowerid = fpowerid;
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

	@Column(name = "roleid", nullable = false)
	public Integer getRoleid() {
		return this.roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	@Column(name = "fpowerid", nullable = false)
	public Integer getFpowerid() {
		return this.fpowerid;
	}

	public void setFpowerid(Integer fpowerid) {
		this.fpowerid = fpowerid;
	}

}