package com.cg.iter.feedbackmanagementsystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.EnrollmentDao;
import com.cg.iter.feedbackmanagementsystem.dao.TrainingProgramDao;
import com.cg.iter.feedbackmanagementsystem.dao.UserDao;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;
import com.cg.iter.feedbackmanagementsystem.dto.User;

@Service
public class EnrollmentService implements IEnrollmentService{

	@Autowired
	private EnrollmentDao enrollmentDao;
	
	@Autowired
	private TrainingProgramDao trainingProgramDao;
	
	@Autowired
	private UserDao userDao;
	
	/**
	 * used to enroll user to a training program
	 * takes id of user and program id to enroll in
	 * checks if already enrolled
	 * if already enrolled,return false
	 * if not enrolled,enrolls the user and return true
	 */
	@Override
	public boolean addEnrollment(int userId,String programId) {

		List<Enrollment> findAll = enrollmentDao.findAll();
		for (Enrollment enrollment : findAll) {
			if(enrollment.getUser().getId()==(userId) && enrollment.getTrainingProgram().getId().equals(programId)) {
				return false;
			}
			
		}
		TrainingProgram trainingProgram = trainingProgramDao.getOne(programId);
		User user = userDao.getOne(userId);
		
		enrollmentDao.save(new Enrollment(user,trainingProgram));
		return true;
		
		
	
	}

	
	
}
