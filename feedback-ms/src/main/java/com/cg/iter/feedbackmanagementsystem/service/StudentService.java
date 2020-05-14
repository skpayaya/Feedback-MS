package com.cg.iter.feedbackmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.EnrollmentDao;
import com.cg.iter.feedbackmanagementsystem.dao.FeedbackDao;
import com.cg.iter.feedbackmanagementsystem.dao.StudentDao;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.exception.InvalidFeedbackException;
import com.cg.iter.feedbackmanagementsystem.validator.FeedbackValidators;

@Service
public class StudentService implements IStudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private FeedbackDao feedbackDao;
	@Autowired
	private EnrollmentDao enrollmentDao;

	@Override
	public List<Student> getAllStudents() {
		return studentDao.findAll();
	}

	/**
	 * adds feedback 
	 * validates rating
	 * if student already entered feedback,return false
	 * if student not enrolled,return false
	 * otherwise enter feedback
	 */
	@Override
	public boolean addFeedback(Feedback feedback) throws InvalidFeedbackException {
		String studentId=feedback.getStudent().getId();
		String tpId=feedback.getTrainingProgram().getId();

		//if feedback already present,return false
		List<Feedback> findAll = feedbackDao.findAll();
		for (Feedback feedback2 : findAll) {
			if(feedback2.getTrainingProgram().getId().equals(tpId) && feedback2.getStudent().getId().equals(studentId)) {
				return false;
			}
		}
		//validate rating
		FeedbackValidators.validateRating(feedback);
		//if not enrolled,student can't enter feedback
		boolean enrolled=false;
		List<TrainingProgram> enrolledPrograms = findEnrolledPrograms(studentId);
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
	 * finds the enrolled programs using student ID
	 */
	public List<TrainingProgram> findEnrolledPrograms(String studentId) {
		List<Enrollment> findAll = enrollmentDao.findAll();
		List<TrainingProgram> enrolledPrograms = new ArrayList<>();
		for (Enrollment enrollment : findAll) {
			if(enrollment.getStudent().getId().equals(studentId)) {
				enrolledPrograms.add(enrollment.getTrainingProgram());
			}
		}
		return enrolledPrograms;
	}


}
