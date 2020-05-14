package com.cg.iter.feedbackmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.TrainerDao;
import com.cg.iter.feedbackmanagementsystem.dto.Trainer;
import com.cg.iter.feedbackmanagementsystem.validator.Validators;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService implements ITrainerService{
	
	@Autowired
	private TrainerDao trainerDao;
	/**
	 * returns the list of trainers in database
	 */
	@Override
	public List<Trainer> getAlltrainers() {
		return trainerDao.findAll();
	}

	/**
	 * update the trainer
	 * checks if the trainer is present in database
	 * if present updates the trainer,return true
	 * otherwise return false
	 */
	@Override
	public String updatetrainer(Trainer trainer) {
		
		Optional<Trainer> findById = trainerDao.findById(trainer.getTrainerId());
		if(findById.isEmpty()) {
			return "Trainer not found";
		}
		trainerDao.save(trainer);
		return "Updated trainer";
		
	}
	/**
	 * return the trainer by id
	 * 
	 */
	@Override
	public Trainer getTrainerById(String id) {
		return trainerDao.getOne(id);
	}

}
