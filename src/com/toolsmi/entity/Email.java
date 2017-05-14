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
 * Email entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "email", catalog = "contributionmanager")
public class Email implements java.io.Serializable {

	// Fields

	private Integer id;
	private String sendname;
	private Integer sendid;
	private Integer receiveid;
	private String receivename;
	private String title;
	private String content;
	private String file;
	private String filetype;
	private Integer status;
	private Date maketime;

	// Constructors

	/** default constructor */
	public Email() {
	}

	/** minimal constructor */
	public Email(Integer sendid, Integer receiveid, Integer status, Date maketime) {
		this.sendid = sendid;
		this.receiveid = receiveid;
		this.status = status;
		this.maketime = maketime;
	}

	/** full constructor */
	public Email(Integer sendid, Integer receiveid, String title,
			String content, String file, String filetype, Integer status,
			Date maketime) {
		this.sendid = sendid;
		this.receiveid = receiveid;
		this.title = title;
		this.content = content;
		this.file = file;
		this.filetype = filetype;
		this.status = status;
		this.maketime = maketime;
	}

	public Email(Integer id,Integer sendid,Integer receiveid, String title, String content, Integer status,
			Date maketime) {
		this.id = id;
		this.sendid=sendid;
		this.receiveid=receiveid;
		this.title = title;
		this.content = content;
		this.status = status;
		this.maketime = maketime;
	}
	
	public Email(Integer status){
		this.status=status;
	}

	
	public String getSendname() {
		return sendname;
	}

	public void setSendname(String sendname) {
		this.sendname = sendname;
	}

	public String getReceivename() {
		return receivename;
	}

	public void setReceivename(String receivename) {
		this.receivename = receivename;
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

	@Column(name = "sendid", nullable = false)
	public Integer getSendid() {
		return this.sendid;
	}

	public void setSendid(Integer sendid) {
		this.sendid = sendid;
	}

	@Column(name = "reciveid", nullable = false)
	public Integer getReceiveid() {
		return this.receiveid;
	}

	public void setReceiveid(Integer receiveid) {
		this.receiveid = receiveid;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "file", length = 200)
	public String getFile() {
		return this.file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Column(name = "filetype", length = 20)
	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Column(name = "status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "maketime", nullable = false, length = 10)
	public Date getMaketime() {
		return this.maketime;
	}

	public void setMaketime(Date maketime) {
		this.maketime = maketime;
	}

}