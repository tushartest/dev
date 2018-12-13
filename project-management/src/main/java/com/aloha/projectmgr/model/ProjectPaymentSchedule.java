package com.aloha.projectmgr.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "project_payment_schedule")
public class ProjectPaymentSchedule implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "paymentId", updatable = false, nullable = false, unique = true)
	private int paymentId;
	private int projectId;
	@Size(min = 0, max = 30)
	@Column(length = 30)
	private String title;
	@Size(min = 0, max = 30)
	@Column(length = 30)
	private String amount;
	@Column(name = "expected_date")
	private Date expecteddate;
	@Column(name = "amt_received_flag")
	private int amtreceivedflag;
	@Column(name = "update_date")
	private Date updatedate;
	@Size(min = 0, max = 300)
	@Column(length = 300)
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
	public Date getExpecteddate() {
		return expecteddate;
	}
	public void setExpecteddate(Date expecteddate) {
		this.expecteddate = expecteddate;
	}
	public int getAmtreceivedflag() {
		return amtreceivedflag;
	}
	public void setAmtreceivedflag(int amtreceivedflag) {
		this.amtreceivedflag = amtreceivedflag;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + amtreceivedflag;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result
				+ ((expecteddate == null) ? 0 : expecteddate.hashCode());
		result = prime * result + paymentId;
		result = prime * result + projectId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result
				+ ((updatedate == null) ? 0 : updatedate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjectPaymentSchedule other = (ProjectPaymentSchedule) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (amtreceivedflag != other.amtreceivedflag)
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (expecteddate == null) {
			if (other.expecteddate != null)
				return false;
		} else if (!expecteddate.equals(other.expecteddate))
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (projectId != other.projectId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updatedate == null) {
			if (other.updatedate != null)
				return false;
		} else if (!updatedate.equals(other.updatedate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProjectPaymentSchedule [paymentId=" + paymentId
				+ ", projectId=" + projectId + ", title=" + title + ", amount="
				+ amount + ", expecteddate=" + expecteddate
				+ ", amtreceivedflag=" + amtreceivedflag + ", updatedate="
				+ updatedate + ", comments=" + comments + "]";
	}
	
	
}
