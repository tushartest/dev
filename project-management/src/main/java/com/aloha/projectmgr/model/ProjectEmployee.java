package com.aloha.projectmgr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ProjectEmployee")
public class ProjectEmployee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projectId", updatable = false, nullable = false, unique=true)  
	private int projectId;
    @Column(name = "emp_id")
	private int emp_id;
	@Size(min = 0, max = 100,message="Name should have atleast 0-100 characters")
	@Column(length=100)
	private String emp_name;
	@Size(min = 0, max = 50)
	@Column(length=50)
	private String emp_email;
	@Size(min = 0, max = 50)
	@Column(length=50)
	private String emp_contactNo;
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_email() {
		return emp_email;
	}
	public void setEmp_email(String emp_email) {
		this.emp_email = emp_email;
	}
	public String getEmp_contactNo() {
		return emp_contactNo;
	}
	public void setEmp_contactNo(String emp_contactNo) {
		this.emp_contactNo = emp_contactNo;
	}
	
}
