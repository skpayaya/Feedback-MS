package com.cg.iter.feedbackmanagementsystem.dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class TrainingProgram {

	@Id
	private String id;
	
	@ManyToOne
	private Course course;
	
	@OneToOne
	private Trainer trainer;
	
	private LocalDate startDate;
	private LocalDate endDate;
	public TrainingProgram() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Trainer getTrainer() {
		return trainer;
	}
	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public TrainingProgram(String id, Course course, Trainer trainer, LocalDate startDate, LocalDate endDate) {
		super();
		this.id = id;
		this.course = course;
		this.trainer = trainer;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	@Override
	public String toString() {
		return "TrainingProgram [id=" + id + ", course=" + course.getCourseName() + ", trainer=" + trainer.getTrainerName() + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}




	

}