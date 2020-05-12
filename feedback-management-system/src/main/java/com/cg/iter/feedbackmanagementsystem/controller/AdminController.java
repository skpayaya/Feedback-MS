package com.cg.iter.feedbackmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.feedbackmanagementsystem.dto.Course;
import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.dto.Trainer;
import com.cg.iter.feedbackmanagementsystem.service.ICourseService;
import com.cg.iter.feedbackmanagementsystem.service.IFeedbackService;
import com.cg.iter.feedbackmanagementsystem.service.ITrainerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private ICourseService courseService;
	
	@Autowired
	private IFeedbackService feedbackService;
	
	@Autowired
	private ITrainerService trainerService;
	
//	Faculty skill Maintenance
	
	@GetMapping("/trainers")
	public List<Trainer> getAllTrainers() {
		return trainerService.getAlltrainers();
	}
	
	@GetMapping("/trainers/{id}")
	public Trainer getTrainerById(@PathVariable("id") String id) {
		return trainerService.getTrainerById(id);
	}
	
	@PutMapping("/trainers")
	public void updateSkillsTrainer(@RequestBody Trainer trainer) {
		
		trainerService.updatetrainer(trainer);
	}

//	Course Maintenance
	
	@GetMapping("/courses")
	public List<Course> getAllCourseDetails() {
		return courseService.getAllCourse();
		
	}
	
	@PutMapping("/updatecourse")
	public void updateCourse(@RequestBody Course course) {
		courseService.updateCourse(course);
		
	}
	
//	View Feedback Report
	

	@GetMapping("/defaulters/{id}")
	public List<Student> viewDefaultList(@PathVariable String id) {
		return feedbackService.viewDefaulterList(id);
		
	}
	
	@GetMapping("/feedbacks/{id}")
	public List<Feedback> viewReport(@PathVariable String id) {
		return feedbackService.viewFeedbackReport(id);
		
	}
}

	
