package com.cg.iter.feedbackmanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.feedbackmanagementsystem.dao.TrainerDao;
import com.cg.iter.feedbackmanagementsystem.dto.Trainer;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService implements ITrainerService{
	
	@Autowired
	private TrainerDao trainerDao;
	
	@Override
	public List<Trainer> getAlltrainers() {
		return trainerDao.findAll();
	}
	@Override
	public Trainer addtrainer(Trainer trainer) {
		return trainerDao.save(trainer);
	}
	@Override
	public String updatetrainer(Trainer trainer) {
		
		Optional<Trainer> findById = trainerDao.findById(trainer.getTrainerId());
		if(findById.isEmpty()) {
			return "Trainer not found";
		}
		trainerDao.save(trainer);
		return "Updated trainer";
		
	}
	@Override
	public Trainer getTrainerById(String id) {
		return trainerDao.getOne(id);
	}

}
