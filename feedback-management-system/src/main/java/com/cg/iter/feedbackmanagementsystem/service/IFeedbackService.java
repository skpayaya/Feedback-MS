package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;

public interface IFeedbackService {



	List<Student> viewDefaulterList(String trainingProgramId);

	List<Feedback> viewFeedbackReport(String trainingProgramId);


}
