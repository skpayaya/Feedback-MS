package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Trainer;

public interface ITrainerService {


	Trainer addtrainer(Trainer trainer);

	List<Trainer> getAlltrainers();


	Trainer getTrainerById(String id);

	String updatetrainer(Trainer trainer);

}
