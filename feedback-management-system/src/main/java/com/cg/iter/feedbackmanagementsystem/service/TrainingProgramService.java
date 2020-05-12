package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.TrainingProgramDao;
import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;

@Service
public class TrainingProgramService implements ITrainingProgramService {
	@Autowired
	private TrainingProgramDao trainingProgramDao;
	
	@Override
	public List<TrainingProgram> getAllTrainingPrograms() {
		return trainingProgramDao.findAll();
	}

	@Override
	public void update(TrainingProgram trainingProgram) {
		trainingProgramDao.save(trainingProgram);
		
	}

	@Override
	public TrainingProgram create(TrainingProgram trainingProgram) {
		return trainingProgramDao.save(trainingProgram);
		
	}

	@Override
	public void remove(String id) {
		trainingProgramDao.deleteById(id);
		
	}
}
