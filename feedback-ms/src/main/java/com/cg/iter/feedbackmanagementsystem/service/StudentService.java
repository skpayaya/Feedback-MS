package com.cg.iter.feedbackmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.EnrollmentDao;
import com.cg.iter.feedbackmanagementsystem.dao.FeedbackDao;
import com.cg.iter.feedbackmanagementsystem.dao.UserDao;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.User;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;
import com.cg.iter.feedbackmanagementsystem.validator.FeedbackValidators;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private UserDao userDao;

	@Autowired
	private FeedbackDao feedbackDao;
	@Autowired
	private EnrollmentDao enrollmentDao;

	@Override
	public List<User> getAllStudents() {
		 List<User> studentList = userDao.findAll();
		 List<User> returnList = new ArrayList<>();
		 for (User user : studentList) {
			if(user.getRoles().contains("ROLE_STUDENT")) {
				returnList.add(user);
			}
		}
		 return returnList;
		 
		
	}

	/**
	 * adds feedback 
	 * validates rating
	 * if User already entered feedback,return false
	 * if User not enrolled,return false
	 * otherwise enter feedback
	 */
	@Override
	public boolean addFeedback(Feedback feedback) throws InvalidFeedbackException {
		int userId=feedback.getUser().getId();
		String tpId=feedback.getTrainingProgram().getId();

		//if feedback already present,return false
		List<Feedback> findAll = feedbackDao.findAll();
		for (Feedback feedback2 : findAll) {
			if(feedback2.getTrainingProgram().getId().equals(tpId) && feedback2.getUser().getId()==(userId)) {
				return false;
			}
		}
		//validate rating
		FeedbackValidators.validateRating(feedback);
		//if not enrolled,User can't enter feedback
		boolean enrolled=false;
		List<TrainingProgram> enrolledPrograms = findEnrolledPrograms(userId);
		for (TrainingProgram trainingProgram : enrolledPrograms) {
			if(trainingProgram.getId().equals(tpId)) {
				enrolled=true;
			}
		}
		if(!enrolled)
			return false;

		feedbackDao.save(feedback);
		return true;
	}

	/**
	 * finds the enrolled programs using User ID
	 */
	public List<TrainingProgram> findEnrolledPrograms(int userId) {
		List<Enrollment> findAll = enrollmentDao.findAll();
		List<TrainingProgram> enrolledPrograms = new ArrayList<>();
		for (Enrollment enrollment : findAll) {
			if(enrollment.getUser().getId()==(userId)) {
				enrolledPrograms.add(enrollment.getTrainingProgram());
			}
		}
		return enrolledPrograms;
	}


}
