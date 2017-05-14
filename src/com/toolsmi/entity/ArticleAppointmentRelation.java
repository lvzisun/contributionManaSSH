package com.toolsmi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * ArticleAppointmentRelation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "article_appointment_relation", catalog = "contributionmanager")
public class ArticleAppointmentRelation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer appointmentId;
	private Integer articleId;

	// Constructors

	/** default constructor */
	public ArticleAppointmentRelation() {
	}

	/** full constructor */
	public ArticleAppointmentRelation(Integer appointmentId, Integer articleId) {
		this.appointmentId = appointmentId;
		this.articleId = articleId;
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

	@Column(name = "appointment_id")
	public Integer getAppointmentId() {
		return this.appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	@Column(name = "article_id")
	public Integer getArticleId() {
		return this.articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

}