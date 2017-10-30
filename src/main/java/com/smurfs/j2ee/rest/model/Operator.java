package com.smurfs.j2ee.rest.model;

import java.io.Serializable;

public class Operator implements Serializable{
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	public Operator() {
		// TODO Auto-generated constructor stub
	}
	public Operator(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
