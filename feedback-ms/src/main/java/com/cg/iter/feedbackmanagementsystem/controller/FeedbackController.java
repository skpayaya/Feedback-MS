package com.cg.iter.feedbackmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;
import com.cg.iter.feedbackmanagementsystem.service.IFeedbackService;
import com.cg.iter.feedbackmanagementsystem.service.IStudentService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private IStudentService studentService;
//	View Feedback Report
	@GetMapping("/defaulters/{id}")
	public List<Student> viewDefaultList(@PathVariable String id) throws InvalidFeedbackException {
		return feedbackService.viewDefaulterList(id);
		
	}
	
	@GetMapping("/feedbacks/{id}")
	public List<Feedback> viewReport(@PathVariable String id) throws InvalidFeedbackException {
		return feedbackService.viewFeedbackReport(id);
		
	}
	//	Feedback Entry
	@PostMapping("/addfeedback")
	public String addFeedback(@RequestBody Feedback feedback) throws InvalidFeedbackException {
		studentService.addFeedback(feedback);
		return "Feedback added";
	}
	
	@ExceptionHandler(InvalidFeedbackException.class)
	public String handleException(InvalidFeedbackException e) {
		return e.getMessage();
		
	}
}

	
