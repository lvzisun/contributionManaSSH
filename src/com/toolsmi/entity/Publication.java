package com.toolsmi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Publication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publication", catalog = "contributionmanager")
public class Publication implements java.io.Serializable {

	// Fields

	private Integer id;
	private String publicationname;
	private String publicationidcard;

	// Constructors

	/** default constructor */
	public Publication() {
	}

	/** full constructor */
	public Publication(String publicationname, String publicationidcard) {
		this.publicationname = publicationname;
		this.publicationidcard = publicationidcard;
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

	@Column(name = "publicationname", nullable = false, length = 20)
	public String getPublicationname() {
		return this.publicationname;
	}

	public void setPublicationname(String publicationname) {
		this.publicationname = publicationname;
	}

	@Column(name = "publicationidcard", nullable = false, length = 20)
	public String getPublicationidcard() {
		return this.publicationidcard;
	}

	public void setPublicationidcard(String publicationidcard) {
		this.publicationidcard = publicationidcard;
	}

}