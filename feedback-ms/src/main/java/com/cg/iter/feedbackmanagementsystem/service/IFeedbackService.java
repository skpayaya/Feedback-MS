package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.dto.User;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;

public interface IFeedbackService {



	List<User> viewDefaulterList(String trainingProgramId) throws InvalidFeedbackException;

	List<Feedback> viewFeedbackReport(String trainingProgramId) throws InvalidFeedbackException;


	List<TrainingProgram> getProgramsForFeedback(int id);

	

}
