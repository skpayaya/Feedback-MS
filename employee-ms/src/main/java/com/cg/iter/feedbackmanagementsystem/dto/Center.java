package com.cg.iter.feedbackmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Center {
	@Id
	private String centerId;
	private String centerAddress;
	private String centerName;
	public String getCenterId() {
		return centerId;
	}
	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
	public String getCenterAddress() {
		return centerAddress;
	}
	public void setCenterAddress(String centerAddress) {
		this.centerAddress = centerAddress;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public Center() {
		super();
	}
	public Center(String centerId, String centerAddress, String centerName) {
		super();
		this.centerId = centerId;
		this.centerAddress = centerAddress;
		this.centerName = centerName;
	}
	
	

}