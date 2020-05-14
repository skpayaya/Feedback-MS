package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.Trainer;

public interface ITrainerService {


	List<Trainer> getAlltrainers();

	String updatetrainer(Trainer trainer);

	Trainer getTrainerById(String id);

}
