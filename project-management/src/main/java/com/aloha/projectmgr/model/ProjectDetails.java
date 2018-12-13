package com.aloha.projectmgr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
@Entity
@Table(name="projectDetails")
public class ProjectDetails implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "projectId", updatable = false, nullable = false, unique=true)  
	private int projectId;

	@Size(min = 0, max = 100)
	@Column(length=100)
	private String projectType;
	@Size(min = 0, max = 100)
	@Column(length=50)
	private String contactNo;
	@Size(min = 0, max = 50)
	@Column(length=50)
	private String ownername;
	@Size(min = 0, max = 100)
	@Column(length=100)
	private String contactPerson;	
	@Size(min = 0, max = 200)
	@Column(length=200)
	private String address;
	private Date startDate;
	private String proposedcost;

	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectType() {
		return projectType;
	}
	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getProposedcost() {
		return proposedcost;
	}
	public void setProposedcost(String proposedcost) {
		this.proposedcost = proposedcost;
	}

	
}
