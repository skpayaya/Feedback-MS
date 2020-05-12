package com.cg.iter.feedbackmanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.feedbackmanagementsystem.dto.TrainingProgram;

@Repository
public interface TrainingProgramDao extends JpaRepository<TrainingProgram, String> {

}
