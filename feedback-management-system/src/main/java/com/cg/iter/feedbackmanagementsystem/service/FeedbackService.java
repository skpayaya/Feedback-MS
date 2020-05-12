package com.cg.iter.feedbackmanagementsystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.EnrollmentDao;
import com.cg.iter.feedbackmanagementsystem.dao.FeedbackDao;
import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;
import com.cg.iter.feedbackmanagementsystem.dto.Feedback;
import com.cg.iter.feedbackmanagementsystem.dto.Student;

@Service
public class FeedbackService implements IFeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;
	@Autowired
	private EnrollmentDao enrollmentDao;
	@Override
	public List<Student> viewDefaulterList(String trainingProgramId)
	{		
		//finding the enrolled students for the training program
		List<Enrollment> findAll = enrollmentDao.findAll();
		List<Student> enrolled= new ArrayList<>();
		for (Enrollment enrollment : findAll) {
			if(enrollment.getTrainingProgram().getId().equals(trainingProgramId)) {
				enrolled.add(enrollment.getStudent());
			}
		}

		//find the defaulter
		List<Feedback> viewFeedbackReport = viewFeedbackReport(trainingProgramId);
		List<Student> defaulters = new ArrayList<>(enrolled);
		for (Feedback feedback : viewFeedbackReport) {
			if(defaulters.contains(feedback.getStudent())) {
				defaulters.remove(feedback.getStudent());
			}
		}
		return defaulters;
	}


	@Override
	public List<Feedback> viewFeedbackReport(String trainingProgramId) {
		List<Feedback> findAll = feedbackDao.findAll();
		List<Feedback> report =new ArrayList<>();
		for (Feedback feedback : findAll) {
			if(feedback.getTrainingProgram().getId().equals(trainingProgramId)) {
				report.add(feedback);
			}
		}
		return report;
	}
}
