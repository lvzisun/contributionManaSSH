package com.toolsmi.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Firstpower entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "firstpower", catalog = "contributionmanager")
public class Firstpower implements java.io.Serializable {

	// Fields

	private Integer id;
	private String firstpowername;
	private Set<Secondpower> secondpower;
	
	// Constructors

	/** default constructor */
	public Firstpower() {
	}

	/** full constructor */
	public Firstpower(String firstpowername) {
		this.firstpowername = firstpowername;
	}
	
	public Firstpower(Integer id, String firstpowername) {
		this.id = id;
		this.firstpowername = firstpowername;
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

	@Column(name = "firstpowername", length = 20)
	public String getFirstpowername() {
		return this.firstpowername;
	}

	public void setFirstpowername(String firstpowername) {
		this.firstpowername = firstpowername;
	}

	@OneToMany
	@JoinColumn(name="fpowerid")
	public Set<Secondpower> getSecondpower() {
		return secondpower;
	}

	public void setSecondpower(Set<Secondpower> secondpower) {
		this.secondpower = secondpower;
	}

	
}