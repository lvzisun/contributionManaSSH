package com.toolsmi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Secondpower entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "secondpower", catalog = "contributionmanager")
public class Secondpower implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer firstpowerid;
	private String secondpowername;
	private String href;

	// Constructors

	/** default constructor */
	public Secondpower() {
	}

	/** minimal constructor */
	public Secondpower(Integer firstpowerid, String secondpowername) {
		this.firstpowerid = firstpowerid;
		this.secondpowername = secondpowername;
	}

	/** full constructor */
	public Secondpower(Integer firstpowerid, String secondpowername, String href) {
		this.firstpowerid = firstpowerid;
		this.secondpowername = secondpowername;
		this.href = href;
	}

	public Secondpower(Integer id, Integer firstpowerid, String secondpowername,
			String href) {
		this.id = id;
		this.firstpowerid = firstpowerid;
		this.secondpowername = secondpowername;
		this.href = href;
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

	@Column(name = "firstpowerid", nullable = false, length = 4)
	public Integer getFirstpowerid() {
		return this.firstpowerid;
	}

	public void setFirstpowerid(Integer firstpowerid) {
		this.firstpowerid = firstpowerid;
	}

	@Column(name = "secondpowername", nullable = false, length = 20)
	public String getSecondpowername() {
		return this.secondpowername;
	}

	public void setSecondpowername(String secondpowername) {
		this.secondpowername = secondpowername;
	}

	@Column(name = "href", length = 50)
	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

}