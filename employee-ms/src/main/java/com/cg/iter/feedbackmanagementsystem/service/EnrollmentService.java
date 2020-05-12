package com.cg.iter.feedbackmanagementsystem.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.EnrollmentDao;
import com.cg.iter.feedbackmanagementsystem.dao.StudentDao;
import com.cg.iter.feedbackmanagementsystem.dao.TrainingProgramDao;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.Student;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;

@Service
public class EnrollmentService implements IEnrollmentService{

	@Autowired
	private EnrollmentDao enrollmentDao;
	
	@Autowired
	private TrainingProgramDao trainingProgramDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public boolean addEnrollment(String studentId,String programId) {

		List<Enrollment> findAll = enrollmentDao.findAll();
		for (Enrollment enrollment : findAll) {
			if(enrollment.getStudent().getId().equals(studentId) && enrollment.getTrainingProgram().getId().equals(programId)) {
				return false;
			}
			
		}
		TrainingProgram trainingProgram = trainingProgramDao.getOne(programId);
		Student student = studentDao.getOne(studentId);
		
		enrollmentDao.save(new Enrollment(student,trainingProgram));
		return true;
		
		
	
	}

	
	
}
