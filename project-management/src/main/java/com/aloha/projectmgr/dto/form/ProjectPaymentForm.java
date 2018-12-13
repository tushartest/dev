package com.aloha.projectmgr.dto.form;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectPaymentForm {

	
	private int paymentId;
	private int projectId;
	private String title;
	private String amount;
	private int amtreceivedflag;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date expecteddate;
	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date updatedate;
	private String comments;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public int getAmtreceivedflag() {
		return amtreceivedflag;
	}
	public void setAmtreceivedflag(int amtreceivedflag) {
		this.amtreceivedflag = amtreceivedflag;
	}
	public Date getExpecteddate() {
		return expecteddate;
	}
	public void setExpecteddate(Date expecteddate) {
		this.expecteddate = expecteddate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	
}
