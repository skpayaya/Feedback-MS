package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;
import java.util.Optional;

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

	/**
	 * update the training program
	 * checks if the training program is present
	 * if present updates the training program,return true
	 * otherwise return false
	 */
	@Override
	public boolean update(TrainingProgram trainingProgram) {
		Optional<TrainingProgram> findById = trainingProgramDao.findById(trainingProgram.getId());

		if(findById.isPresent()) {
			trainingProgramDao.save(trainingProgram);
			return true;
		}
		return false;

	}

	/**
	 * adds a new training program
	 * checks if the training program with same ID is present
	 * if not present,adds the training program,return true
	 * otherwise returns false
	 */
	@Override
	public String create(TrainingProgram trainingProgram) {
		Optional<TrainingProgram> findById = trainingProgramDao.findById(trainingProgram.getId());
		if(findById.isEmpty()) {
			trainingProgramDao.save(trainingProgram);
			return "training program added";
		}
		return "training program not added";

	}

	/**
	 * remove a training program
	 * takes the id of training program as input 
	 * checks if the training program is present
	 * if present removes the training program,return true
	 * otherwise return false
	 */
	@Override
	public boolean remove(String id) {
		Optional<TrainingProgram> findById = trainingProgramDao.findById(id);
		if(findById.isPresent()) {
			trainingProgramDao.deleteById(id);
			return true;
		}
		return false;
		

	}
}
