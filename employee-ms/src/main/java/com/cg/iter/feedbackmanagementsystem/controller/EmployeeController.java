package com.cg.iter.feedbackmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.feedbackmanagementsystem.dto.Trainer;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.dto.User;
import com.cg.iter.feedbackmanagementsystem.service.IEnrollmentService;
import com.cg.iter.feedbackmanagementsystem.service.IStudentService;
import com.cg.iter.feedbackmanagementsystem.service.ITrainerService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private ITrainerService trainerService;

	@Autowired
	private IEnrollmentService enrollmentService;

	//	Faculty skill Maintenance
	@Autowired
	private IStudentService studentService;

	@GetMapping("/trainers")
	public List<Trainer> getAllTrainers() {
		return trainerService.getAlltrainers();
	}

	@GetMapping("/trainers/{id}")
	public Trainer getTrainerById(@PathVariable("id") String id) {
		return trainerService.getTrainerById(id);
	}

	@PutMapping("/trainers")
	public String updateSkillsTrainer(@RequestBody Trainer trainer) {

		return trainerService.updatetrainer(trainer);
	}
	@PostMapping("/enroll/{studentId}")
	public String enrollParticipant(@RequestBody TrainingProgram trainingProgram,@PathVariable int studentId) {

		if(enrollmentService.addEnrollment(studentId, trainingProgram.getId())) {
			return "Succesfully enrolled";
		}
		return "Already enrolled";
	}

	@GetMapping("/studentlist")
	public List<User> getAllStudents() {
		return studentService.getAllStudents();
	}


}


