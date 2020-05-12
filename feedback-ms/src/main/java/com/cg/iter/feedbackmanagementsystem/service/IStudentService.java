package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;

public interface IStudentService {

	List<Student> getAllStudents();

	boolean addFeedback(Feedback feedback) throws InvalidFeedbackException;

}
