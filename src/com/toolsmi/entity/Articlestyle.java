package com.toolsmi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Articlestyle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "articlestyle", catalog = "contributionmanager")
public class Articlestyle implements java.io.Serializable {

	// Fields

	private Integer id;
	private String stylename;

	// Constructors

	/** default constructor */
	public Articlestyle() {
	}

	/** full constructor */
	public Articlestyle(String stylename) {
		this.stylename = stylename;
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

	@Column(name = "stylename", nullable = false, length = 10)
	public String getStylename() {
		return this.stylename;
	}

	public void setStylename(String stylename) {
		this.stylename = stylename;
	}

}