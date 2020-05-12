package com.cg.iter.feedbackmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.service.IEnrollmentService;
import com.cg.iter.feedbackmanagementsystem.service.IFeedbackService;
import com.cg.iter.feedbackmanagementsystem.service.IStudentService;
import com.cg.iter.feedbackmanagementsystem.service.ITrainingProgramService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/coordinator")
public class CoordinatorController {

	@Autowired
	private ITrainingProgramService trainingProgramService;
	
	@Autowired
	private IStudentService studentService;
	
	@Autowired
	private IEnrollmentService enrollmentService;
	
	@Autowired
	private IFeedbackService feedbackService;
	
	
//	Training program Maintenance
	@PostMapping("/trainingprograms")
	public void addTrainingProgram(TrainingProgram trainingProgram) {
		trainingProgramService.create(trainingProgram);
	}
	@DeleteMapping("/trainingprograms")
	public void deleteTrainingProgram(@PathVariable String id) {
		trainingProgramService.remove(id);
	}
	@GetMapping("/trainingprograms")
	public List<TrainingProgram> getAllTrainingPrograms() {
		return trainingProgramService.getAllTrainingPrograms();
		
	}
	
	@PutMapping("/trainingprograms")
	public void updateTrainingProgram(TrainingProgram trainingProgram) {
		trainingProgramService.update(trainingProgram);
	}
	
	

	@PostMapping("/enroll/{studentId}")
	public String enrollParticipant(@RequestBody TrainingProgram trainingProgram,@PathVariable String studentId) {
		
		if(enrollmentService.addEnrollment(studentId, trainingProgram.getId())) {
			return "Succesfully enrolled";
		}
		return "Already enrolled";
	}
	
	@GetMapping("/studentlist")
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
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
