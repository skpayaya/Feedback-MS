package com.cg.iter.feedbackmanagementsystem.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

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

import com.cg.iter.feedbackmanagementsystem.dto.Course;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.service.ICourseService;
import com.cg.iter.feedbackmanagementsystem.service.ITrainingProgramService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private ITrainingProgramService trainingProgramService;
	@Autowired
	private ICourseService courseService;
	//	Course Maintenance

	@GetMapping("/courses")
	public List<Course> getAllCourseDetails() {
		return courseService.getAllCourse();

	}

	@PutMapping("/updatecourse")
	public String updateCourse(@RequestBody Course course) {
		return (courseService.updateCourse(course)) ;
	}


	//	Training program Maintenance
	@PostMapping("/trainingprograms")
	public String addTrainingProgram(@RequestBody TrainingProgram trainingProgram) {
		return trainingProgramService.create(trainingProgram);
	}
	@DeleteMapping("/trainingprograms/{id}")
	public String deleteTrainingProgram(@PathVariable String id) {
		try {
		if(trainingProgramService.remove(id)) {
			return "Deleted";
		}
		}catch (Exception e) {
			return "Another table depends on this trainingProgram.It can't be deleted";
		}
		
		return "Unable to Delete";
	}
	@GetMapping("/trainingprograms")
	public List<TrainingProgram> getAllTrainingPrograms() {
		return trainingProgramService.getAllTrainingPrograms();

	}

	@PutMapping("/trainingprograms")
	public String updateTrainingProgram(@RequestBody TrainingProgram trainingProgram) {
		if(trainingProgramService.update(trainingProgram)) {
			return "Updated Training Program";
		}
		return "Unable to update";

	}
}


