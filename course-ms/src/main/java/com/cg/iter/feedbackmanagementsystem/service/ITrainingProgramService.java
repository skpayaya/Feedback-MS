package com.cg.iter.feedbackmanagementsystem.service;

import java.util.List;

import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;

public interface ITrainingProgramService {

	boolean update(TrainingProgram trainingProgram);

	List<TrainingProgram> getAllTrainingPrograms();

	String create(TrainingProgram trainingProgram);

	boolean remove(String id);

}
