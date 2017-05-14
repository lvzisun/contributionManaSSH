package com.toolsmi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Article entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article", catalog = "contributionmanager")
public class Article implements java.io.Serializable {

	// Fields

	private Integer id;
	private String title;
	private Integer authorid;
	private Integer typeid;
	private Integer styleid;
	private String content;
	private Integer status;

	// Constructors

	/** default constructor */
	public Article() {
	}

	/** minimal constructor */
	public Article(Integer authorid, Integer typeid, Integer styleid,
			Integer status) {
		this.authorid = authorid;
		this.typeid = typeid;
		this.styleid = styleid;
		this.status = status;
	}

	/** full constructor */
	public Article(String title, Integer authorid, Integer typeid,
			Integer styleid, String content, Integer status) {
		this.title = title;
		this.authorid = authorid;
		this.typeid = typeid;
		this.styleid = styleid;
		this.content = content;
		this.status = status;
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

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "authorid", nullable = false)
	public Integer getAuthorid() {
		return this.authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}

	@Column(name = "typeid", nullable = false)
	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	@Column(name = "styleid", nullable = false)
	public Integer getStyleid() {
		return this.styleid;
	}

	public void setStyleid(Integer styleid) {
		this.styleid = styleid;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}