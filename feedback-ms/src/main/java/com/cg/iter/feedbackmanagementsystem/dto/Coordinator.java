package com.cg.iter.feedbackmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Coordinator extends Employee {
	
	@Id
	private String id;
	
	@OneToOne
	private Center center;

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
}
