package com.cg.iter.feedbackmanagementsystem.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Trainer_Spring")
public class Trainer {

	public Trainer() {
	}


	@Id
	private String trainerId;

	private String trainerName;

	@ElementCollection
	private Set<String> skill=new HashSet<>();

	
	public Trainer(String trainerName, Set<String> skill) {
		super();
		this.trainerName = trainerName;
		this.skill = skill;
	}


	
	public String getTrainerId() {
		return trainerId;
	}



	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}



	public Trainer(String trainerId, String trainerName, Set<String> skill) {
		super();
		this.trainerId = trainerId;
		this.trainerName = trainerName;
		this.skill = skill;
	}



	public String getTrainerName() {
		return trainerName;
	}


	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}


	public Set<String> getSkill() {
		return skill;
	}

	public void setSkill(Set<String> skill) {
		this.skill = skill;
	}




}