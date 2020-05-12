package com.cg.iter.feedbackmanagementsystem.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.iter.feedbackmanagementsystem.dto.Enrollment;

@Repository
public interface EnrollmentDao extends JpaRepository<Enrollment, String> {

}
