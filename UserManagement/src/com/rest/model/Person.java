package com.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="person")
public class Person {
	private String firstname;
	private String lastname;
	private long id;
	private String emailid;
	private String action;

	

	

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@Override
	public String toString(){
		return id+"::"+firstname+"::"+lastname+"::"+emailid;
	}

}