package com.cg.iter.feedbackmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	private IFeedbackService feedbackService;
	@Autowired
	private IStudentService studentService;
//	View Feedback Report
	@GetMapping("/defaulters/{id}")
	public List<Student> viewDefaultList(@PathVariable String id) {
		return feedbackService.viewDefaulterList(id);
		
	}
	
	@GetMapping("/feedbacks/{id}")
	public List<Feedback> viewReport(@PathVariable String id) {
		return feedbackService.viewFeedbackReport(id);
		
	}
	//	Feedback Entry
	@PostMapping("/addfeedback")
	public void addFeedback(@RequestBody Feedback feedback) throws InvalidFeedbackException {
		studentService.addFeedback(feedback);
	}
	
	@ExceptionHandler(InvalidFeedbackException.class)
	public String handleException(InvalidFeedbackException e) {
		return e.getMessage();
		
	}
}

	
