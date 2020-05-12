package com.cg.iter.feedbackmanagementsystem.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Enrollment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private TrainingProgram trainingProgram;

	public Enrollment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Enrollment(Student student, TrainingProgram trainingProgram) {
		super();
		this.student = student;
		this.trainingProgram = trainingProgram;
	}


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public TrainingProgram getTrainingProgram() {
		return trainingProgram;
	}

	public void setTrainingProgram(TrainingProgram trainingProgram) {
		this.trainingProgram = trainingProgram;
	}
	
	
}
