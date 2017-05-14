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
 * Appointment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "appointment", catalog = "contributionmanager")
public class Appointment implements java.io.Serializable {

	// Fields

	private Integer id;
	private String openCard;
	private Integer publicationid;
	private String demand;
	private Integer status;
	private Date starttime;
	private Date endtime;
	private Integer createid;

	// Constructors

	/** default constructor */
	public Appointment() {
	}

	/** minimal constructor */
	public Appointment(String openCard, Integer publicationid, String demand,
			Integer status, Date starttime, Date endtime) {
		this.openCard = openCard;
		this.publicationid = publicationid;
		this.demand = demand;
		this.status = status;
		this.starttime = starttime;
		this.endtime = endtime;
	}

	/** full constructor */
	public Appointment(String openCard, Integer publicationid, String demand,
			Integer status, Date starttime, Date endtime, Integer createid) {
		this.openCard = openCard;
		this.publicationid = publicationid;
		this.demand = demand;
		this.status = status;
		this.starttime = starttime;
		this.endtime = endtime;
		this.createid = createid;
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

	@Column(name = "openCard", nullable = false, length = 6)
	public String getOpenCard() {
		return this.openCard;
	}

	public void setOpenCard(String openCard) {
		this.openCard = openCard;
	}

	@Column(name = "publicationid", nullable = false)
	public Integer getPublicationid() {
		return this.publicationid;
	}

	public void setPublicationid(Integer publicationid) {
		this.publicationid = publicationid;
	}

	@Column(name = "demand", nullable = false, length = 1000)
	public String getDemand() {
		return this.demand;
	}

	public void setDemand(String demand) {
		this.demand = demand;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "starttime", nullable = false, length = 10)
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "endtime", nullable = false, length = 10)
	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	@Column(name = "createid")
	public Integer getCreateid() {
		return this.createid;
	}

	public void setCreateid(Integer createid) {
		this.createid = createid;
	}

}