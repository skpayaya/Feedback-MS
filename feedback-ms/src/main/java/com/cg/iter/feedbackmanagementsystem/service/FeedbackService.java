package com.cg.iter.feedbackmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.EnrollmentDao;
import com.cg.iter.feedbackmanagementsystem.dao.FeedbackDao;
import com.cg.iter.feedbackmanagementsystem.dao.TrainingProgramDao;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.User;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;

@Service
public class FeedbackService implements IFeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	@Autowired
	private EnrollmentDao enrollmentDao;
	@Autowired
	private TrainingProgramDao trainingProgramDao;
	@Override
	/**
	 * Find the defaulter list for a training program
	 * Takes the program id as input ,finds the enrolled Users and 
	 * then finds who haven't entered the feedback
	 */
	public List<User> viewDefaulterList(String trainingProgramId) throws InvalidFeedbackException
	{		
		Optional<TrainingProgram> findById = trainingProgramDao.findById(trainingProgramId);
		if(findById.isEmpty()) {
			throw new InvalidFeedbackException("Training program not found");
		}
		//finding the enrolled Users for the training program
		List<Enrollment> findAll = enrollmentDao.findAll();
		List<User> defaulters= new ArrayList<>();
		for (Enrollment enrollment : findAll) {
			if(enrollment.getTrainingProgram().getId().equals(trainingProgramId)) {
				defaulters.add(enrollment.getUser());
			}
		}

		//find the defaulter
		List<Feedback> viewFeedbackReport = viewFeedbackReport(trainingProgramId);
		for (Feedback feedback : viewFeedbackReport) {
			if(defaulters.contains(feedback.getUser())) {
				defaulters.remove(feedback.getUser());
			}
		}
		return defaulters;
	}


	/**
	 * returns the list of feedback for a training program
	 * @throws InvalidFeedbackException 
	 */
	@Override
	public List<Feedback> viewFeedbackReport(String trainingProgramId) throws InvalidFeedbackException {
		Optional<TrainingProgram> findById = trainingProgramDao.findById(trainingProgramId);
		if(findById.isEmpty()) {
			throw new InvalidFeedbackException("Training program not found");
		}
		List<Feedback> findAll = feedbackDao.findAll();
		List<Feedback> report =new ArrayList<>();
		for (Feedback feedback : findAll) {
			if(feedback.getTrainingProgram().getId().equals(trainingProgramId)) {
				report.add(feedback);
			}
		}
		return report;
	}
	/*
	 * Return the list of training programs for which feedback hasn't  been entered
	 */

	@Override
	public List<TrainingProgram> getProgramsForFeedback(int id) {
		//findEnrolled programs
		List<Enrollment> enrolledPrograms = enrollmentDao.findAll();
		List<TrainingProgram> returnList=new ArrayList<>();
		for (Enrollment enrollment : enrolledPrograms) {
			if(enrollment.getUser().getId()==(id)) {
				returnList.add(enrollment.getTrainingProgram());
			}
		}
		List<Feedback> findAll = feedbackDao.findAll();
		for (Feedback feedback : findAll) {
			if(feedback.getUser().getId()==(id))
				returnList.remove(feedback.getTrainingProgram());
		}
		return returnList;
	}
}
