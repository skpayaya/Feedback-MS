package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;

public interface ITrainingProgramService {

	void update(TrainingProgram trainingProgram);

	List<TrainingProgram> getAllTrainingPrograms();

	TrainingProgram create(TrainingProgram trainingProgram);

	void remove(String id);

}
